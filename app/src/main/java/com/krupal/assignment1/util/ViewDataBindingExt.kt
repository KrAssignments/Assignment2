package com.krupal.assignment1.util

import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> T.executeWithAction(action: T.() -> Unit) {
    action()
    executePendingBindings()
}