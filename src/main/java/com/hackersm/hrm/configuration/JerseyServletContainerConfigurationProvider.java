package com.hackersm.hrm.configuration;

import java.util.Set;

public abstract interface JerseyServletContainerConfigurationProvider {
  public abstract Set<Class<?>> getConfigurationClasses();
}
