package com.moura.randomizeme.presentation.common.base

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.moura.randomizeme.common.AndroidDisposable
import com.moura.randomizeme.common.dependency.presentation.PresentationModule
import javax.inject.Inject

abstract class BaseFragment: Fragment() {

    protected val disposables = AndroidDisposable()

    @Inject lateinit var router: Router

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.subcomponent(PresentationModule())
    }

    protected val injector get() = presentationComponent

    override fun onDestroyView() {
        disposables.disposeAll()
        super.onDestroyView()
    }

}