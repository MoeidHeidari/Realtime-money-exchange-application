package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideCompositeDisposableFactory
    implements Factory<CompositeDisposable> {
  private final ActivityModule module;

  public ActivityModule_ProvideCompositeDisposableFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public CompositeDisposable get() {
    return Preconditions.checkNotNull(
        module.provideCompositeDisposable(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CompositeDisposable> create(ActivityModule module) {
    return new ActivityModule_ProvideCompositeDisposableFactory(module);
  }

  /** Proxies {@link ActivityModule#provideCompositeDisposable()}. */
  public static CompositeDisposable proxyProvideCompositeDisposable(ActivityModule instance) {
    return instance.provideCompositeDisposable();
  }
}
