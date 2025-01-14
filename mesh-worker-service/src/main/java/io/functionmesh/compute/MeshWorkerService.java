/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.functionmesh.compute;

import io.functionmesh.compute.rest.api.FunctionsImpl;
import io.functionmesh.compute.rest.api.SinksImpl;
import io.functionmesh.compute.rest.api.SourcesImpl;
import io.functionmesh.compute.worker.MeshConnectorsManager;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.apis.CustomObjectsApi;
import io.kubernetes.client.util.Config;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.broker.ServiceConfiguration;
import org.apache.pulsar.broker.authentication.AuthenticationService;
import org.apache.pulsar.broker.authorization.AuthorizationService;
import org.apache.pulsar.broker.cache.ConfigurationCacheService;
import org.apache.pulsar.broker.resources.PulsarResources;
import org.apache.pulsar.common.conf.InternalConfigurationData;
import org.apache.pulsar.common.util.SimpleTextOutputStream;
import org.apache.pulsar.functions.worker.ErrorNotifier;
import org.apache.pulsar.functions.worker.WorkerConfig;
import org.apache.pulsar.functions.worker.WorkerService;
import org.apache.pulsar.functions.worker.service.api.Functions;
import org.apache.pulsar.functions.worker.service.api.FunctionsV2;
import org.apache.pulsar.functions.worker.service.api.Sinks;
import org.apache.pulsar.functions.worker.service.api.Sources;
import org.apache.pulsar.functions.worker.service.api.Workers;

import java.io.IOException;

/**
 * Function mesh proxy implement.
 */
@Slf4j
@Getter
public class MeshWorkerService implements WorkerService {

    private volatile boolean isInitialized = false;

    private WorkerConfig workerConfig;
    private Functions<MeshWorkerService> functions;
    private FunctionsV2<MeshWorkerService> functionsV2;
    private Sinks<MeshWorkerService> sinks;
    private Sources<MeshWorkerService> sources;
    private CoreV1Api coreV1Api;
    private CustomObjectsApi customObjectsApi;
    private ApiClient apiClient;

    private AuthenticationService authenticationService;
    private AuthorizationService authorizationService;

    private MeshConnectorsManager connectorsManager;

    public MeshWorkerService() {

    }

    @Override
    public void initAsStandalone(WorkerConfig workerConfig) throws Exception {
        this.init(workerConfig);
    }

    @Override
    public void initInBroker(ServiceConfiguration brokerConfig,
                             WorkerConfig workerConfig, PulsarResources pulsarResources,
                             ConfigurationCacheService configurationCacheService,
                             InternalConfigurationData internalConfigurationData) throws Exception {
        this.init(workerConfig);
    }

    public void init(WorkerConfig workerConfig) throws Exception {
        this.workerConfig = workerConfig;
        this.initKubernetesClient();
        this.functions = new FunctionsImpl(() -> MeshWorkerService.this);
        this.sources = new SourcesImpl(() -> MeshWorkerService.this);
        this.sinks = new SinksImpl(() -> MeshWorkerService.this);
    }

    private void initKubernetesClient() throws IOException {
        try {
            apiClient = Config.defaultClient();
            coreV1Api = new CoreV1Api(Config.defaultClient());
            customObjectsApi = new CustomObjectsApi(Config.defaultClient());
        } catch (java.io.IOException e) {
            log.error("Initialization kubernetes client failed, exception: {}", e.getMessage());
            throw e;
        }
    }

    public void start(AuthenticationService authenticationService,
                      AuthorizationService authorizationService,
                      ErrorNotifier errorNotifier) {
        this.authenticationService = authenticationService;
        this.authorizationService = authorizationService;
        this.connectorsManager = new MeshConnectorsManager();
    }

    public void stop() {

    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public Workers<? extends WorkerService> getWorkers() {
        // No need to implement since in this mode, there's no function worker
        // Consider ban this api in the production environment
        return null;
    }

    public void generateFunctionsStats(SimpleTextOutputStream out) {
        // to do https://github.com/streamnative/function-mesh/issues/56
    }

}
