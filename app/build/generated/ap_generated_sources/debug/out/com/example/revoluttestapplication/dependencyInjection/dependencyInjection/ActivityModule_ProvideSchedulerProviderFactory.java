package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import com.example.revoluttestapplication.utils.rx.SchedulerProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideSchedulerProviderFactory
    implements Factory<SchedulerProvider> {
  private final ActivityModule module;

  public ActivityModule_ProvideSchedulerProviderFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SchedulerProvider get() {
    return Preconditions.checkNotNull(
        module.provideSchedulerProvider(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SchedulerProvider> create(ActivityModule module) {
    return new ActivityModule_ProvideSchedulerProviderFactory(module);
  }

  /** Proxies {@link ActivityModule#provideSchedulerProvider()}. */
  public static SchedulerProvider proxyProvideSchedulerProvider(ActivityModule instance) {
    return instance.provideSchedulerProvider();
  }
}
