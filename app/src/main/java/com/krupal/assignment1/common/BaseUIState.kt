package com.krupal.assignment1.common

import android.view.View

open class BaseUIState {
    fun getViewVisibility(isVisible: Boolean) = if (isVisible) View.VISIBLE else View.GONE
}