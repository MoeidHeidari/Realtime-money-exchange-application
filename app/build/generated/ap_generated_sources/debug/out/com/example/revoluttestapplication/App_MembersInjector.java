package com.example.revoluttestapplication;

import com.example.revoluttestapplication.data.DataProvider;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class App_MembersInjector implements MembersInjector<App> {
  private final Provider<DataProvider> mDataManagerProvider;

  private final Provider<CalligraphyConfig> mCalligraphyConfigProvider;

  public App_MembersInjector(
      Provider<DataProvider> mDataManagerProvider,
      Provider<CalligraphyConfig> mCalligraphyConfigProvider) {
    assert mDataManagerProvider != null;
    this.mDataManagerProvider = mDataManagerProvider;
    assert mCalligraphyConfigProvider != null;
    this.mCalligraphyConfigProvider = mCalligraphyConfigProvider;
  }

  public static MembersInjector<App> create(
      Provider<DataProvider> mDataManagerProvider,
      Provider<CalligraphyConfig> mCalligraphyConfigProvider) {
    return new App_MembersInjector(mDataManagerProvider, mCalligraphyConfigProvider);
  }

  @Override
  public void injectMembers(App instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mDataManager = mDataManagerProvider.get();
    instance.mCalligraphyConfig = mCalligraphyConfigProvider.get();
  }

  public static void injectMDataManager(App instance, Provider<DataProvider> mDataManagerProvider) {
    instance.mDataManager = mDataManagerProvider.get();
  }

  public static void injectMCalligraphyConfig(
      App instance, Provider<CalligraphyConfig> mCalligraphyConfigProvider) {
    instance.mCalligraphyConfig = mCalligraphyConfigProvider.get();
  }
}
