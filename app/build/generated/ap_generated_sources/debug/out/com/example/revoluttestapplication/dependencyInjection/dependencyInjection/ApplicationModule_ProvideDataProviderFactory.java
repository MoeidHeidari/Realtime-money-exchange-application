package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import com.example.revoluttestapplication.data.AppDataProvider;
import com.example.revoluttestapplication.data.DataProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ApplicationModule_ProvideDataProviderFactory implements Factory<DataProvider> {
  private final ApplicationModule module;

  private final Provider<AppDataProvider> appDataManagerProvider;

  public ApplicationModule_ProvideDataProviderFactory(
      ApplicationModule module, Provider<AppDataProvider> appDataManagerProvider) {
    assert module != null;
    this.module = module;
    assert appDataManagerProvider != null;
    this.appDataManagerProvider = appDataManagerProvider;
  }

  @Override
  public DataProvider get() {
    return Preconditions.checkNotNull(
        module.provideDataProvider(appDataManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DataProvider> create(
      ApplicationModule module, Provider<AppDataProvider> appDataManagerProvider) {
    return new ApplicationModule_ProvideDataProviderFactory(module, appDataManagerProvider);
  }

  /** Proxies {@link ApplicationModule#provideDataProvider(AppDataProvider)}. */
  public static DataProvider proxyProvideDataProvider(
      ApplicationModule instance, AppDataProvider appDataManager) {
    return instance.provideDataProvider(appDataManager);
  }
}
