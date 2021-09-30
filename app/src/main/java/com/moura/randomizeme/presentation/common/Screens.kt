package com.moura.randomizeme.presentation.common

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.moura.randomizeme.presentation.scene.start.StartFragment

object Screens {

    val Start get() = FragmentScreen { StartFragment.newInstance() }

}