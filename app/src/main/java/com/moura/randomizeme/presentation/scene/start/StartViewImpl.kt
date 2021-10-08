package com.moura.randomizeme.presentation.scene.start

import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxbinding4.view.longClicks
import com.moura.randomizeme.databinding.FragmentStartBinding
import com.moura.randomizeme.presentation.common.base.BaseViewImpl
import com.moura.randomizeme.presentation.model.OpItem
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class StartViewImpl @Inject constructor(
    private val binding: FragmentStartBinding
) : BaseViewImpl(binding), StartView {

    override val onRandomizeClick: PublishSubject<Unit> = PublishSubject.create()
    override val onRandomizeLongClick: PublishSubject<Unit> = PublishSubject.create()

    init {

        binding.randomButton.clicks().subscribe(onRandomizeClick)
        binding.randomButton.longClicks().subscribe(onRandomizeLongClick)

    }

    override fun getListText(): String = binding.listEdit.text.toString()

    override fun setListText(text: String) {
        binding.listEdit.setText(text)
    }
}