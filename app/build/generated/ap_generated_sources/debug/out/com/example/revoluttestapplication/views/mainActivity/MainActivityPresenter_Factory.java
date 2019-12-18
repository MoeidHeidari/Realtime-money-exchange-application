package com.example.revoluttestapplication.views.mainActivity;

import com.example.revoluttestapplication.data.DataProvider;
import com.example.revoluttestapplication.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivityPresenter_Factory<V extends MainActivityMvpView>
    implements Factory<MainActivityPresenter<V>> {
  private final MembersInjector<MainActivityPresenter<V>> mainActivityPresenterMembersInjector;

  private final Provider<DataProvider> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public MainActivityPresenter_Factory(
      MembersInjector<MainActivityPresenter<V>> mainActivityPresenterMembersInjector,
      Provider<DataProvider> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert mainActivityPresenterMembersInjector != null;
    this.mainActivityPresenterMembersInjector = mainActivityPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public MainActivityPresenter<V> get() {
    return MembersInjectors.injectMembers(
        mainActivityPresenterMembersInjector,
        new MainActivityPresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends MainActivityMvpView> Factory<MainActivityPresenter<V>> create(
      MembersInjector<MainActivityPresenter<V>> mainActivityPresenterMembersInjector,
      Provider<DataProvider> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new MainActivityPresenter_Factory<V>(
        mainActivityPresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
