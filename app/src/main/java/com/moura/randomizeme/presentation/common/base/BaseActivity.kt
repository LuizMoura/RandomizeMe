package com.moura.randomizeme.presentation.common.base

import androidx.appcompat.app.AppCompatActivity
import com.moura.randomizeme.common.MainAppllication
import com.moura.randomizeme.common.dependency.activity.ActivityModule
import com.moura.randomizeme.common.dependency.presentation.PresentationModule

abstract class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MainAppllication).appComponent

    val activityComponent by lazy {
        appComponent.subcomponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.subcomponent(PresentationModule())
    }

    protected val injector get() = presentationComponent

}