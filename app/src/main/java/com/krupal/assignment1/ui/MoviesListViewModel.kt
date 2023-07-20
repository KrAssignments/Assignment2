package com.krupal.assignment1.ui

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.krupal.assignment1.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    movieRepository: MovieRepository
) : ViewModel() {
    val movieItemsUIStates =
        movieRepository.getMovies().map { pagingdata -> pagingdata.map { movieModel -> } }
}