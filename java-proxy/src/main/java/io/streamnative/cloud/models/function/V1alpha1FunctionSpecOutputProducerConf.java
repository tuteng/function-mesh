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
/*
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.18.2
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.streamnative.cloud.models.function;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * V1alpha1FunctionSpecOutputProducerConf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-30T11:26:19.304Z[Etc/UTC]")
public class V1alpha1FunctionSpecOutputProducerConf {
  public static final String SERIALIZED_NAME_MAX_PENDING_MESSAGES = "maxPendingMessages";
  @SerializedName(SERIALIZED_NAME_MAX_PENDING_MESSAGES)
  private Integer maxPendingMessages;

  public static final String SERIALIZED_NAME_MAX_PENDING_MESSAGES_ACROSS_PARTITIONS = "maxPendingMessagesAcrossPartitions";
  @SerializedName(SERIALIZED_NAME_MAX_PENDING_MESSAGES_ACROSS_PARTITIONS)
  private Integer maxPendingMessagesAcrossPartitions;

  public static final String SERIALIZED_NAME_USE_THREAD_LOCAL_PRODUCERS = "useThreadLocalProducers";
  @SerializedName(SERIALIZED_NAME_USE_THREAD_LOCAL_PRODUCERS)
  private Boolean useThreadLocalProducers;


  public V1alpha1FunctionSpecOutputProducerConf maxPendingMessages(Integer maxPendingMessages) {
    
    this.maxPendingMessages = maxPendingMessages;
    return this;
  }

   /**
   * Get maxPendingMessages
   * @return maxPendingMessages
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getMaxPendingMessages() {
    return maxPendingMessages;
  }


  public void setMaxPendingMessages(Integer maxPendingMessages) {
    this.maxPendingMessages = maxPendingMessages;
  }


  public V1alpha1FunctionSpecOutputProducerConf maxPendingMessagesAcrossPartitions(Integer maxPendingMessagesAcrossPartitions) {
    
    this.maxPendingMessagesAcrossPartitions = maxPendingMessagesAcrossPartitions;
    return this;
  }

   /**
   * Get maxPendingMessagesAcrossPartitions
   * @return maxPendingMessagesAcrossPartitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getMaxPendingMessagesAcrossPartitions() {
    return maxPendingMessagesAcrossPartitions;
  }


  public void setMaxPendingMessagesAcrossPartitions(Integer maxPendingMessagesAcrossPartitions) {
    this.maxPendingMessagesAcrossPartitions = maxPendingMessagesAcrossPartitions;
  }


  public V1alpha1FunctionSpecOutputProducerConf useThreadLocalProducers(Boolean useThreadLocalProducers) {
    
    this.useThreadLocalProducers = useThreadLocalProducers;
    return this;
  }

   /**
   * Get useThreadLocalProducers
   * @return useThreadLocalProducers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getUseThreadLocalProducers() {
    return useThreadLocalProducers;
  }


  public void setUseThreadLocalProducers(Boolean useThreadLocalProducers) {
    this.useThreadLocalProducers = useThreadLocalProducers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1FunctionSpecOutputProducerConf v1alpha1FunctionSpecOutputProducerConf = (V1alpha1FunctionSpecOutputProducerConf) o;
    return Objects.equals(this.maxPendingMessages, v1alpha1FunctionSpecOutputProducerConf.maxPendingMessages) &&
        Objects.equals(this.maxPendingMessagesAcrossPartitions, v1alpha1FunctionSpecOutputProducerConf.maxPendingMessagesAcrossPartitions) &&
        Objects.equals(this.useThreadLocalProducers, v1alpha1FunctionSpecOutputProducerConf.useThreadLocalProducers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxPendingMessages, maxPendingMessagesAcrossPartitions, useThreadLocalProducers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1FunctionSpecOutputProducerConf {\n");
    sb.append("    maxPendingMessages: ").append(toIndentedString(maxPendingMessages)).append("\n");
    sb.append("    maxPendingMessagesAcrossPartitions: ").append(toIndentedString(maxPendingMessagesAcrossPartitions)).append("\n");
    sb.append("    useThreadLocalProducers: ").append(toIndentedString(useThreadLocalProducers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

