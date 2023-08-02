package com.krupal.assignment1.ui

import android.content.Context
import androidx.paging.LoadState
import com.krupal.assignment1.R
import com.krupal.assignment1.common.BaseUIState

data class MoviesUIState constructor(
    private val loadState: LoadState,
) : BaseUIState() {
    fun getProgressBarVisibility() = getViewVisibility(isVisible = loadState is LoadState.Loading)

    fun getListVisibility() = getViewVisibility(isVisible = loadState is LoadState.NotLoading)

    fun getErrorVisibility() = getViewVisibility(isVisible = loadState is LoadState.Error)

    fun getErrorMessage(context: Context) = if (loadState is LoadState.Error) {
        loadState.error.localizedMessage ?: context.getString(R.string.something_went_wrong)
    } else ""
}