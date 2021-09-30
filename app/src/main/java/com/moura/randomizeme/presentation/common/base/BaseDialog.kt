package com.moura.randomizeme.presentation.common.base

import androidx.fragment.app.DialogFragment
import com.moura.randomizeme.common.AndroidDisposable
import com.moura.randomizeme.common.dependency.presentation.PresentationModule

abstract class BaseDialog: DialogFragment() {

    protected val disposables = AndroidDisposable()

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.subcomponent(PresentationModule())
    }

    protected val injector get() = presentationComponent

    override fun onDestroyView() {
        disposables.disposeAll()
        super.onDestroyView()
    }

}