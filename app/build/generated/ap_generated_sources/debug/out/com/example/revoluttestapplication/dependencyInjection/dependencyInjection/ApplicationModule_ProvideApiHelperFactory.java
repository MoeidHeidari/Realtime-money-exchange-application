package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import com.example.revoluttestapplication.data.network.ApiHelper;
import com.example.revoluttestapplication.data.network.AppApiHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideApiHelperFactory implements Factory<ApiHelper> {
  private final ApplicationModule module;

  private final Provider<AppApiHelper> appApiHelperProvider;

  public ApplicationModule_ProvideApiHelperFactory(
      ApplicationModule module, Provider<AppApiHelper> appApiHelperProvider) {
    assert module != null;
    this.module = module;
    assert appApiHelperProvider != null;
    this.appApiHelperProvider = appApiHelperProvider;
  }

  @Override
  public ApiHelper get() {
    return Preconditions.checkNotNull(
        module.provideApiHelper(appApiHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ApiHelper> create(
      ApplicationModule module, Provider<AppApiHelper> appApiHelperProvider) {
    return new ApplicationModule_ProvideApiHelperFactory(module, appApiHelperProvider);
  }

  /** Proxies {@link ApplicationModule#provideApiHelper(AppApiHelper)}. */
  public static ApiHelper proxyProvideApiHelper(
      ApplicationModule instance, AppApiHelper appApiHelper) {
    return instance.provideApiHelper(appApiHelper);
  }
}
