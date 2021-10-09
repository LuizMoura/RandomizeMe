package com.moura.randomizeme.presentation.scene.start

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.moura.randomizeme.BuildConfig
import com.moura.randomizeme.R
import com.moura.randomizeme.presentation.common.ScreenViewFactory
import com.moura.randomizeme.presentation.common.base.BaseFragment
import com.moura.randomizeme.presentation.model.OpItem
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
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.help, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.help) {
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.app_name)
                .setMessage(getString(R.string.about_text, BuildConfig.VERSION_NAME))
                .setCancelable(true)
                .create()
                .show()
            true
        } else
            super.onOptionsItemSelected(item)
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
            Toast.makeText(context, R.string.shuffle_done_toast, Toast.LENGTH_SHORT).show()
        }

        return screenView.rootView
    }
}