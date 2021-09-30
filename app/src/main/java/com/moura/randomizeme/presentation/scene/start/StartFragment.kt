package com.moura.randomizeme.presentation.scene.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moura.randomizeme.presentation.common.ScreenViewFactory
import com.moura.randomizeme.presentation.common.Screens
import com.moura.randomizeme.presentation.common.base.BaseFragment
import com.tokenlab.betterlog.BetterLog
import javax.inject.Inject

class StartFragment : BaseFragment() {

    @Inject lateinit var viewFactory: ScreenViewFactory
    private lateinit var screenView: StartView

    companion object {
        fun newInstance() = StartFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        screenView = viewFactory.getStartView(container)

        screenView.onHostButtonClicked.subscribe {
            BetterLog.d(msg="Button clicked")
        }

        return screenView.rootView
    }
}