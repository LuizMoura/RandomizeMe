package com.moura.randomizeme.presentation.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.github.terrakok.cicerone.NavigatorHolder
import com.moura.randomizeme.R
import com.moura.randomizeme.presentation.common.base.BaseActivity
import com.moura.randomizeme.presentation.scene.start.StartFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = Navigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        setTheme(R.style.Theme_RandomizeMe)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, StartFragment.newInstance())
                .commit()
        }

    }
}