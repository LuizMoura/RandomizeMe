package com.moura.randomizeme.presentation.scene.start

import com.moura.randomizeme.presentation.common.base.BaseView
import com.moura.randomizeme.presentation.model.OpItem
import io.reactivex.rxjava3.core.Observable

interface StartView: BaseView {

    val onRandomizeClick: Observable<Unit>
    val onRandomizeLongClick: Observable<Unit>

    fun getListText(): String
    fun setListText(text: String)

}