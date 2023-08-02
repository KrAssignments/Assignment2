package com.krupal.assignment1.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.krupal.assignment1.data.datasource.MoviePagingDataSource
import com.krupal.assignment1.data.model.Content
import com.krupal.assignment1.data.service.MovieService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
) : MovieRepository {
    override fun getMovies(query: String?): Flow<PagingData<Content>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MoviePagingDataSource(movieService, query) }
        ).flow
    }
}