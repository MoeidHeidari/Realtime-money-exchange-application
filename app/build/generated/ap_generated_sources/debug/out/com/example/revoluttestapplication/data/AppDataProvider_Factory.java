package com.example.revoluttestapplication.data;

import android.content.Context;
import com.example.revoluttestapplication.data.network.ApiHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppDataProvider_Factory implements Factory<AppDataProvider> {
  private final Provider<Context> contextProvider;

  private final Provider<ApiHelper> apiHelperProvider;

  public AppDataProvider_Factory(
      Provider<Context> contextProvider, Provider<ApiHelper> apiHelperProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert apiHelperProvider != null;
    this.apiHelperProvider = apiHelperProvider;
  }

  @Override
  public AppDataProvider get() {
    return new AppDataProvider(contextProvider.get(), apiHelperProvider.get());
  }

  public static Factory<AppDataProvider> create(
      Provider<Context> contextProvider, Provider<ApiHelper> apiHelperProvider) {
    return new AppDataProvider_Factory(contextProvider, apiHelperProvider);
  }
}
