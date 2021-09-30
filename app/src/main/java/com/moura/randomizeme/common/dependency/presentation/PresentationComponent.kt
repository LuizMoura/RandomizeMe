package com.moura.randomizeme.common.dependency.presentation

import com.moura.randomizeme.presentation.common.MainActivity
import com.moura.randomizeme.presentation.scene.start.StartFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: StartFragment)

}