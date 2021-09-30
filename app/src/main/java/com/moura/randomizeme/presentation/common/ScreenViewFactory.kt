package com.moura.randomizeme.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.moura.randomizeme.databinding.FragmentStartBinding
import com.moura.randomizeme.presentation.scene.start.StartView
import com.moura.randomizeme.presentation.scene.start.StartViewImpl
import javax.inject.Inject
import javax.inject.Provider

class ScreenViewFactory @Inject constructor(
    private val layoutInflater: Provider<LayoutInflater>
) {

    fun getStartView(parent: ViewGroup?): StartView = StartViewImpl(
        FragmentStartBinding.inflate(layoutInflater.get(), parent, false)
    )


}
