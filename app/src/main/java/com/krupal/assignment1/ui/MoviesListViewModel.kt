package com.krupal.assignment1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.switchMap
import androidx.paging.map
import com.krupal.assignment1.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    movieRepository: MovieRepository
) : ViewModel() {

    val searchQueryLiveData: MutableLiveData<String?> = MutableLiveData("")

    val movieItemsUIStates = searchQueryLiveData.distinctUntilChanged().switchMap {
        movieRepository.getMovies(it)
            .map { pagingData -> pagingData.map { movieModel -> MoviesItemUIState(movieModel) } }
            .asLiveData()
    }

}