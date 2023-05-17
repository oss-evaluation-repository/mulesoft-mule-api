/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * API for Mule Runtime.
 * 
 * @moduleGraph
 * @since 1.6
 */
module org.mule.runtime.api {

  requires transitive org.mule.runtime.api.annotations;
  requires org.mule.runtime.metadata.model.api;
  requires org.mule.runtime.metadata.model.message;
  requires org.mule.runtime.artifact.declaration;
  requires org.mule.runtime.artifact.declaration.persistence;
  
  requires java.activation;
  requires java.naming;
  requires java.sql;
  
  // SLF4J is the API provided by the Mule Runtime
  // for artifacts to use the underlying logging functionality
  requires transitive org.slf4j;
  
  requires com.github.benmanes.caffeine;
  requires com.google.common;
  requires com.google.gson;
  requires org.apache.commons.io;
  requires org.apache.commons.lang3;
  requires semver4j;
  
  exports org.mule.runtime.api.app.declaration.serialization;
  exports org.mule.runtime.api.artifact;
  exports org.mule.runtime.api.bulk;
  exports org.mule.runtime.api.cluster;
  exports org.mule.runtime.api.component;
  exports org.mule.runtime.api.component.execution;
  exports org.mule.runtime.api.component.location;
  exports org.mule.runtime.api.config;
  exports org.mule.runtime.api.config.custom;
  exports org.mule.runtime.api.connection;
  exports org.mule.runtime.api.connection.serialization;
  exports org.mule.runtime.api.connectivity;
  exports org.mule.runtime.api.deployment.management;
  exports org.mule.runtime.api.deployment.meta;
  exports org.mule.runtime.api.deployment.persistence;
  exports org.mule.runtime.api.dsl;
  exports org.mule.runtime.api.el;
  exports org.mule.runtime.api.el.validation;
  exports org.mule.runtime.api.event;
  exports org.mule.runtime.api.exception;
  exports org.mule.runtime.api.functional;
  exports org.mule.runtime.api.healthcheck;
  exports org.mule.runtime.api.i18n;
  exports org.mule.runtime.api.ioc;
  exports org.mule.runtime.api.interception;
  exports org.mule.runtime.api.legacy.exception;
  exports org.mule.runtime.api.lifecycle;
  exports org.mule.runtime.api.lock;
  exports org.mule.runtime.api.message;
  exports org.mule.runtime.api.message.error.matcher;
  exports org.mule.runtime.api.meta;
  exports org.mule.runtime.api.meta.type;
  exports org.mule.runtime.api.meta.model;
  exports org.mule.runtime.api.meta.model.config;
  exports org.mule.runtime.api.meta.model.data.sample;
  exports org.mule.runtime.api.meta.model.declaration.fluent;
  exports org.mule.runtime.api.meta.model.declaration.fluent.util;
  exports org.mule.runtime.api.meta.model.deprecated;
  exports org.mule.runtime.api.meta.model.connection;
  exports org.mule.runtime.api.meta.model.construct;
  exports org.mule.runtime.api.meta.model.display;
  exports org.mule.runtime.api.meta.model.error;
  exports org.mule.runtime.api.meta.model.function;
  exports org.mule.runtime.api.meta.model.nested;
  exports org.mule.runtime.api.meta.model.notification;
  exports org.mule.runtime.api.meta.model.operation;
  exports org.mule.runtime.api.meta.model.parameter;
  exports org.mule.runtime.api.meta.model.source;
  exports org.mule.runtime.api.meta.model.stereotype;
  exports org.mule.runtime.api.meta.model.util;
  exports org.mule.runtime.api.meta.model.version;
  exports org.mule.runtime.api.memory.management;
  exports org.mule.runtime.api.memory.provider;
  exports org.mule.runtime.api.memory.provider.type;
  exports org.mule.runtime.api.metadata;
  exports org.mule.runtime.api.metadata.descriptor;
  exports org.mule.runtime.api.metadata.resolving;
  exports org.mule.runtime.api.notification;
  exports org.mule.runtime.api.parameterization;
  exports org.mule.runtime.api.sampledata;
  exports org.mule.runtime.api.scheduler;
  exports org.mule.runtime.api.security;
  exports org.mule.runtime.api.serialization;
  exports org.mule.runtime.api.service;
  exports org.mule.runtime.api.source;
  exports org.mule.runtime.api.store;
  exports org.mule.runtime.api.streaming;
  exports org.mule.runtime.api.streaming.bytes;
  exports org.mule.runtime.api.streaming.object;
  exports org.mule.runtime.api.streaming.exception;
  exports org.mule.runtime.api.time;
  exports org.mule.runtime.api.tls;
  exports org.mule.runtime.api.transformation;
  exports org.mule.runtime.api.tx;
  exports org.mule.runtime.api.util;
  exports org.mule.runtime.api.util.collection;
  exports org.mule.runtime.api.util.concurrent;
  exports org.mule.runtime.api.util.xmlsecurity;
  exports org.mule.runtime.api.value;
  
  // Exposed to other modules of the Mule Runtime, but internal to other users
  exports org.mule.runtime.internal.dsl to
      org.mule.runtime.dsl.api,
      org.mule.runtime.extensions.api,
      org.mule.runtime.artifact.ast,
      org.mule.runtime.artifact.ast.serialization,
      org.mule.runtime.artifact.ast.serialization.test,
      org.mule.runtime.artifact.ast.test,
      org.mule.runtime.artifact.ast.xmlParser,
      org.mule.runtime.extension.model;
  
  // Allow introspection for serialization/deserialization by Gson
  opens org.mule.runtime.api.component to
      com.google.gson;
  opens org.mule.runtime.api.deployment.meta to
      com.google.gson;
  opens org.mule.runtime.api.meta.model to
      com.google.gson;
  opens org.mule.runtime.api.meta.model.data.sample to
      com.google.gson;
  opens org.mule.runtime.api.meta.model.display to
      com.google.gson;
  opens org.mule.runtime.api.meta.model.error to
      com.google.gson;
  opens org.mule.runtime.api.meta.model.parameter to
      com.google.gson;
  opens org.mule.runtime.api.meta.model.stereotype to
      com.google.gson;
  opens org.mule.runtime.api.metadata to
      com.google.gson;
  opens org.mule.runtime.api.metadata.resolving to
      com.google.gson;
  opens org.mule.runtime.api.value to
      com.google.gson;
  

}