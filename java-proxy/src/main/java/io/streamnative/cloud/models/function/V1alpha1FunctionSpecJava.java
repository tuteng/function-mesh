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
 * V1alpha1FunctionSpecJava
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-30T11:26:19.304Z[Etc/UTC]")
public class V1alpha1FunctionSpecJava {
  public static final String SERIALIZED_NAME_JAR = "jar";
  @SerializedName(SERIALIZED_NAME_JAR)
  private String jar;

  public static final String SERIALIZED_NAME_JAR_LOCATION = "jarLocation";
  @SerializedName(SERIALIZED_NAME_JAR_LOCATION)
  private String jarLocation;


  public V1alpha1FunctionSpecJava jar(String jar) {
    
    this.jar = jar;
    return this;
  }

   /**
   * Get jar
   * @return jar
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJar() {
    return jar;
  }


  public void setJar(String jar) {
    this.jar = jar;
  }


  public V1alpha1FunctionSpecJava jarLocation(String jarLocation) {
    
    this.jarLocation = jarLocation;
    return this;
  }

   /**
   * Get jarLocation
   * @return jarLocation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJarLocation() {
    return jarLocation;
  }


  public void setJarLocation(String jarLocation) {
    this.jarLocation = jarLocation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1alpha1FunctionSpecJava v1alpha1FunctionSpecJava = (V1alpha1FunctionSpecJava) o;
    return Objects.equals(this.jar, v1alpha1FunctionSpecJava.jar) &&
        Objects.equals(this.jarLocation, v1alpha1FunctionSpecJava.jarLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jar, jarLocation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1alpha1FunctionSpecJava {\n");
    sb.append("    jar: ").append(toIndentedString(jar)).append("\n");
    sb.append("    jarLocation: ").append(toIndentedString(jarLocation)).append("\n");
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
