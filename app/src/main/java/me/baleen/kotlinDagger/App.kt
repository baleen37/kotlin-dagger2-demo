package me.baleen.kotlinDagger

import android.app.Application
import me.baleen.kotlinDagger.di.component.ApplicationComponent
import me.baleen.kotlinDagger.di.component.DaggerApplicationComponent
import me.baleen.kotlinDagger.di.module.ApplicationModule

class App : Application() {

  companion object {
    @JvmStatic lateinit var graph: ApplicationComponent
  }

  /**
   * Called when the application is starting, before any activity, service,
   * or receiver objects (excluding content providers) have been created.
   * Implementations should be as quick as possible (for example using
   * lazy initialization of state) since the time spent in this function
   * directly impacts the performance of starting the first activity,
   * service, or receiver in a process.
   * If you override this method, be sure to call super.onCreate().
   */
  override fun onCreate() {
    super.onCreate()

    initApplicationComponent(this)
  }

  fun initApplicationComponent(application: Application) {
    graph = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(application))
        .build()
  }
}