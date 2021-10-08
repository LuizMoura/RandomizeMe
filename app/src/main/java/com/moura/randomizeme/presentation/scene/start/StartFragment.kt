package com.moura.randomizeme.presentation.scene.start

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.moura.randomizeme.presentation.common.ScreenViewFactory
import com.moura.randomizeme.presentation.common.Screens
import com.moura.randomizeme.presentation.common.base.BaseFragment
import com.moura.randomizeme.presentation.model.OpItem
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

        screenView.onRandomizeClick.subscribe {
            val list = OpItem.listFromString(screenView.getListText())
            val choosen = list.random()
            Toast.makeText(context, choosen.text, Toast.LENGTH_SHORT).show()
        }

        screenView.onRandomizeLongClick.subscribe {
            val list = OpItem.listFromString(screenView.getListText())
            screenView.setListText(list.shuffled().joinToString("\n") { it.text })
        }

        return screenView.rootView
    }
}