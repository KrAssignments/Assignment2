package com.krupal.assignment1.ui

import android.content.SearchRecentSuggestionsProvider

class MoviesSearchProvider : SearchRecentSuggestionsProvider() {
    init {
        setupSuggestions(AUTHORITY, MODE)
    }

    companion object {
        const val AUTHORITY = "com.krupal.assignment1.ui.MoviesSearchProvider"
        const val MODE: Int = DATABASE_MODE_QUERIES
    }
}