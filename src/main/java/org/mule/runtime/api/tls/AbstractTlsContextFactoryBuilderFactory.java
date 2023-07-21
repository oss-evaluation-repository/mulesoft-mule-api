/*
 * Copyright 2023 Salesforce, Inc. All rights reserved.
 */
package org.mule.runtime.api.tls;

import static java.lang.String.format;
import static java.util.ServiceLoader.load;

import org.mule.api.annotation.NoExtend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class used to create {@link TlsContextFactoryBuilder} objects.
 *
 * @since 1.0
 */
@NoExtend
public abstract class AbstractTlsContextFactoryBuilderFactory {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTlsContextFactoryBuilderFactory.class);

  static {
    try {
      final AbstractTlsContextFactoryBuilderFactory factory = load(AbstractTlsContextFactoryBuilderFactory.class,
                                                                   AbstractTlsContextFactoryBuilderFactory.class.getClassLoader())
                                                                       .iterator().next();
      LOGGER.info(format("Loaded TlsContextFactoryBuilderFactory implementation '%s' from classloader '%s'",
                         factory.getClass().getName(), factory.getClass().getClassLoader().toString()));

      DEFAULT_FACTORY = factory;
    } catch (Throwable t) {
      LOGGER.error("Error loading TlsContextFactoryBuilderFactory implementation. Seems there's none in the classpath.", t);
      throw t;
    }
  }

  private static final AbstractTlsContextFactoryBuilderFactory DEFAULT_FACTORY;

  /**
   * The implementation of this abstract class is provided by the Mule Runtime, and loaded during this class initialization.
   * <p>
   * If more than one implementation is found, the classLoading order of those implementations will determine which one is used.
   * Information about this will be logged to aid in the troubleshooting of those cases.
   *
   * @return the implementation of this builder factory provided by the Mule Runtime.
   */
  static final AbstractTlsContextFactoryBuilderFactory getDefaultFactory() {
    return DEFAULT_FACTORY;
  }

  /**
   * @return a fresh {@link TlsContextFactoryBuilder} object.
   */
  protected abstract TlsContextFactoryBuilder create();

}
