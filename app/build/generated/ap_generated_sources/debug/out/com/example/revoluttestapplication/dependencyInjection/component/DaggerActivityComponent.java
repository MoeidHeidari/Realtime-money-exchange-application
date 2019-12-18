package com.example.revoluttestapplication.dependencyInjection.component;

import com.example.revoluttestapplication.data.DataProvider;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ActivityModule;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ActivityModule_ProvideCompositeDisposableFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ActivityModule_ProvideMainActivityPresenterFactory;
import com.example.revoluttestapplication.dependencyInjection.dependencyInjection.ActivityModule_ProvideSchedulerProviderFactory;
import com.example.revoluttestapplication.utils.rx.SchedulerProvider;
import com.example.revoluttestapplication.views.mainActivity.MainActivity;
import com.example.revoluttestapplication.views.mainActivity.MainActivityMvpPresenter;
import com.example.revoluttestapplication.views.mainActivity.MainActivityMvpView;
import com.example.revoluttestapplication.views.mainActivity.MainActivityPresenter;
import com.example.revoluttestapplication.views.mainActivity.MainActivityPresenter_Factory;
import com.example.revoluttestapplication.views.mainActivity.MainActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<DataProvider> getDataProvider;

  private Provider<SchedulerProvider> provideSchedulerProvider;

  private Provider<CompositeDisposable> provideCompositeDisposableProvider;

  private Provider<MainActivityPresenter<MainActivityMvpView>> mainActivityPresenterProvider;

  private Provider<MainActivityMvpPresenter<MainActivityMvpView>>
      provideMainActivityPresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getDataProvider =
        new Factory<DataProvider>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public DataProvider get() {
            return Preconditions.checkNotNull(
                applicationComponent.getDataProvider(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideSchedulerProvider =
        ActivityModule_ProvideSchedulerProviderFactory.create(builder.activityModule);

    this.provideCompositeDisposableProvider =
        ActivityModule_ProvideCompositeDisposableFactory.create(builder.activityModule);

    this.mainActivityPresenterProvider =
        MainActivityPresenter_Factory.create(
            MembersInjectors.<MainActivityPresenter<MainActivityMvpView>>noOp(),
            getDataProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideMainActivityPresenterProvider =
        ActivityModule_ProvideMainActivityPresenterFactory.create(
            builder.activityModule, mainActivityPresenterProvider);

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(provideMainActivityPresenterProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    mainActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
