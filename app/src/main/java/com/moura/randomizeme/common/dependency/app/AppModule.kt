package com.moura.randomizeme.common.dependency.app

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun application() = application

    @Provides
    @AppScope
    fun cicerone() = Cicerone.create()

    @Provides
    fun router(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    fun navigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()


}