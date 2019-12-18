package com.example.revoluttestapplication.dependencyInjection.component;

import android.app.Application;
import android.content.Context;
import com.example.revoluttestapplication.App;
import com.example.revoluttestapplication.App_MembersInjector;
import com.example.revoluttestapplication.data.AppDataProvider;
import com.example.revoluttestapplication.data.AppDataProvider_Factory;
import com.example.revoluttestapplication.data.DataProvider;
import com.example.revoluttestapplication.data.network.ApiHelper;
import com.example.revoluttestapplication.data.network.AppApiHelper_Factory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule_ProvideApiHelperFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule_ProvideApplicationFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule_ProvideCalligraphyDefaultConfigFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule_ProvideContextFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ApplicationModule_ProvideDataProviderFactory;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;

  private Provider<ApiHelper> provideApiHelperProvider;

  private Provider<AppDataProvider> appDataProvider;

  private Provider<DataProvider> provideDataProvider;

  private Provider<CalligraphyConfig> provideCalligraphyDefaultConfigProvider;

  private MembersInjector<App> appMembersInjector;

  private Provider<Application> provideApplicationProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        ApplicationModule_ProvideContextFactory.create(builder.applicationModule);

    this.provideApiHelperProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApiHelperFactory.create(
                builder.applicationModule, AppApiHelper_Factory.create()));

    this.appDataProvider =
        AppDataProvider_Factory.create(provideContextProvider, provideApiHelperProvider);

    this.provideDataProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideDataProviderFactory.create(
                builder.applicationModule, appDataProvider));

    this.provideCalligraphyDefaultConfigProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideCalligraphyDefaultConfigFactory.create(
                builder.applicationModule));

    this.appMembersInjector =
        App_MembersInjector.create(provideDataProvider, provideCalligraphyDefaultConfigProvider);

    this.provideApplicationProvider =
        ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
  }

  @Override
  public Context context() {
    return provideContextProvider.get();
  }

  @Override
  public void inject(App app) {
    appMembersInjector.injectMembers(app);
  }

  @Override
  public Application application() {
    return provideApplicationProvider.get();
  }

  @Override
  public DataProvider getDataProvider() {
    return provideDataProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }
  }
}
