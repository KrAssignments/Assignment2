package com.krupal.assignment1.data.repository

import androidx.paging.PagingData
import com.krupal.assignment1.data.model.Content
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(query: String?): Flow<PagingData<Content>>
}