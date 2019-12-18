package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import com.example.revoluttestapplication.views.mainActivity.MainActivityMvpPresenter;
import com.example.revoluttestapplication.views.mainActivity.MainActivityMvpView;
import com.example.revoluttestapplication.views.mainActivity.MainActivityPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideMainActivityPresenterFactory
    implements Factory<MainActivityMvpPresenter<MainActivityMvpView>> {
  private final ActivityModule module;

  private final Provider<MainActivityPresenter<MainActivityMvpView>> presenterProvider;

  public ActivityModule_ProvideMainActivityPresenterFactory(
      ActivityModule module,
      Provider<MainActivityPresenter<MainActivityMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public MainActivityMvpPresenter<MainActivityMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideMainActivityPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MainActivityMvpPresenter<MainActivityMvpView>> create(
      ActivityModule module,
      Provider<MainActivityPresenter<MainActivityMvpView>> presenterProvider) {
    return new ActivityModule_ProvideMainActivityPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideMainActivityPresenter(MainActivityPresenter)}. */
  public static MainActivityMvpPresenter<MainActivityMvpView> proxyProvideMainActivityPresenter(
      ActivityModule instance, MainActivityPresenter<MainActivityMvpView> presenter) {
    return instance.provideMainActivityPresenter(presenter);
  }
}
