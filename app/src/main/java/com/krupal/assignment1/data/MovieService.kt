package com.krupal.assignment1.data

import com.krupal.assignment1.data.model.ApiResponse

interface MovieService {
    fun getMoviesList(searchKey: String?, pageNo: Int): ApiResponse
}