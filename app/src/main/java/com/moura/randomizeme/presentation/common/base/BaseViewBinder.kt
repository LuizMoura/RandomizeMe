package com.moura.randomizeme.presentation.common.base

import android.content.Context
import androidx.viewbinding.ViewBinding

abstract class BaseViewBinder(private val binding: ViewBinding) {

    val rootView get() = binding.root

    protected val context: Context get() = binding.root.context

}