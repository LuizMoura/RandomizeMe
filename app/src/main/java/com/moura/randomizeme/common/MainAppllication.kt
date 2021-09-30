package com.moura.randomizeme.common

import android.app.Application
import com.moura.randomizeme.common.dependency.app.AppComponent
import com.moura.randomizeme.common.dependency.app.AppModule
import com.moura.randomizeme.common.dependency.app.DaggerAppComponent

class MainAppllication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        internal lateinit var INSTANCE: MainAppllication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}