package com.tenilodev.indekos

import com.tenilodev.indekos.injection.AppComponent
import com.tenilodev.indekos.injection.DaggerAppComponent
import com.tenilodev.indekos.injection.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AndroidStarterApplication : DaggerApplication() {


    lateinit var component : AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder()
                .application(this)
                .networkModule(NetworkModule(Config.base_url))
                .build()
        component.inject(this)
        return component
    }

    override fun onCreate() {
        super.onCreate()
    }

}