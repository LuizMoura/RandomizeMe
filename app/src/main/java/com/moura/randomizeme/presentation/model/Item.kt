package com.moura.randomizeme.presentation.model

data class OpItem(
    val text: String
) {

    companion object {
        fun listFromString(text: String): List<OpItem> {
            return text.split("\n").map { OpItem(it) }
        }
    }

}
