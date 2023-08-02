package com.krupal.assignment1.data.service

import com.krupal.assignment1.data.model.ApiResponse

interface MovieService {
    fun getMoviesList(searchKey: String?, pageNo: Int): ApiResponse
}