package com.example.revoluttestapplication.dependencyInjection.dependencyInjection;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideActivityFactory implements Factory<AppCompatActivity> {
  private final ActivityModule module;

  public ActivityModule_ProvideActivityFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AppCompatActivity get() {
    return Preconditions.checkNotNull(
        module.provideActivity(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AppCompatActivity> create(ActivityModule module) {
    return new ActivityModule_ProvideActivityFactory(module);
  }

  /** Proxies {@link ActivityModule#provideActivity()}. */
  public static AppCompatActivity proxyProvideActivity(ActivityModule instance) {
    return instance.provideActivity();
  }
}
