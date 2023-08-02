package com.krupal.assignment1.data.service

import android.app.Application
import com.krupal.assignment1.data.model.ApiResponse
import com.krupal.assignment1.data.model.ContentItems
import com.krupal.assignment1.data.model.Page
import javax.inject.Inject

class AssetsMovieServiceImpl @Inject constructor(
    val application: Application,
) : MovieService {
    override fun getMoviesList(searchKey: String?, pageNo: Int): ApiResponse {

        val page = Page(
            pageNum = pageNo,
            pageSize = 20,
            contentItems = ContentItems(
                content = listOf()
            ),
            title = "",
            totalContentItems = 20
        )

        return ApiResponse(page)
    }
}