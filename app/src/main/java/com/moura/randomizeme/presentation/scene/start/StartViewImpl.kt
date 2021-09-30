package com.moura.randomizeme.presentation.scene.start

import com.jakewharton.rxbinding4.view.clicks
import com.moura.randomizeme.databinding.FragmentStartBinding
import com.moura.randomizeme.presentation.common.base.BaseViewImpl
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class StartViewImpl @Inject constructor(
    binding: FragmentStartBinding
) : BaseViewImpl(binding), StartView {

    override val onHostButtonClicked: PublishSubject<Unit> = PublishSubject.create()

    init {

        binding.hostButton.clicks().subscribe(onHostButtonClicked)

    }

}