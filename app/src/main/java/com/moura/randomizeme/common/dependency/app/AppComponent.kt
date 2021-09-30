package com.moura.randomizeme.common.dependency.app

import com.moura.randomizeme.common.dependency.activity.ActivityComponent
import com.moura.randomizeme.common.dependency.activity.ActivityModule
import com.moura.randomizeme.common.dependency.presentation.PresentationComponent
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, DataModule::class])
interface AppComponent {

    fun subcomponent(activityModule: ActivityModule): ActivityComponent


}