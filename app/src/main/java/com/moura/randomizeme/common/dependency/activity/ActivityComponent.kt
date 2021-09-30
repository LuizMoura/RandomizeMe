package com.moura.randomizeme.common.dependency.activity

import com.moura.randomizeme.common.dependency.presentation.PresentationComponent
import com.moura.randomizeme.common.dependency.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun subcomponent(presentationModule: PresentationModule): PresentationComponent

}