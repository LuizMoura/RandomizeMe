package com.moura.randomizeme.presentation.scene.start

import com.moura.randomizeme.presentation.common.base.BaseView
import io.reactivex.rxjava3.core.Observable

interface StartView: BaseView {

    val onHostButtonClicked: Observable<Unit>

}