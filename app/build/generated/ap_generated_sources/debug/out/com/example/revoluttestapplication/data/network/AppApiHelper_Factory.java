package com.example.revoluttestapplication.data.network;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppApiHelper_Factory implements Factory<AppApiHelper> {
  private static final AppApiHelper_Factory INSTANCE = new AppApiHelper_Factory();

  @Override
  public AppApiHelper get() {
    return new AppApiHelper();
  }

  public static Factory<AppApiHelper> create() {
    return INSTANCE;
  }
}
