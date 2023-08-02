package com.krupal.assignment1.ui

import com.krupal.assignment1.common.BaseUIState
import com.krupal.assignment1.data.model.Content

data class MoviesItemUIState constructor(
    private val model: Content
) : BaseUIState() {
    fun getImageUrl() = model.posterImage

    fun getName() = model.name
}