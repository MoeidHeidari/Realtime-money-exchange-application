package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideCalligraphyDefaultConfigFactory
    implements Factory<CalligraphyConfig> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideCalligraphyDefaultConfigFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public CalligraphyConfig get() {
    return Preconditions.checkNotNull(
        module.provideCalligraphyDefaultConfig(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CalligraphyConfig> create(ApplicationModule module) {
    return new ApplicationModule_ProvideCalligraphyDefaultConfigFactory(module);
  }

  /** Proxies {@link ApplicationModule#provideCalligraphyDefaultConfig()}. */
  public static CalligraphyConfig proxyProvideCalligraphyDefaultConfig(ApplicationModule instance) {
    return instance.provideCalligraphyDefaultConfig();
  }
}
