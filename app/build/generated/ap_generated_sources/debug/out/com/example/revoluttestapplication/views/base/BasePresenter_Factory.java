package com.example.revoluttestapplication.views.base;

import com.example.revoluttestapplication.data.DataProvider;
import com.example.revoluttestapplication.utils.rx.SchedulerProvider;
import com.example.revoluttestapplication.views.base.interfaces.BaseMvpView;
import dagger.internal.Factory;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasePresenter_Factory<V extends BaseMvpView>
    implements Factory<BasePresenter<V>> {
  private final Provider<DataProvider> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public BasePresenter_Factory(
      Provider<DataProvider> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public BasePresenter<V> get() {
    return new BasePresenter<V>(
        dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get());
  }

  public static <V extends BaseMvpView> Factory<BasePresenter<V>> create(
      Provider<DataProvider> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new BasePresenter_Factory<V>(
        dataManagerProvider, schedulerProvider, compositeDisposableProvider);
  }
}
