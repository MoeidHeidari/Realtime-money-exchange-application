package com.example.revoluttestapplication.views.mainActivity;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MainActivityMvpPresenter<MainActivityMvpView>> presenterProvider;

  public MainActivity_MembersInjector(
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> presenterProvider) {
    return new MainActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      MainActivity instance,
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
