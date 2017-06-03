package me.baleen.kotlinDagger.di.component

import dagger.Component
import me.baleen.kotlinDagger.App
import me.baleen.kotlinDagger.ui.main.MainActivity
import me.baleen.kotlinDagger.di.module.ApplicationModule
import me.baleen.kotlinDagger.di.module.NetModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class,
        NetModule::class
))
interface ApplicationComponent {

  fun inject(app: App)

  fun inject(mainActivity: MainActivity)
}