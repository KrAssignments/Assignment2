package com.krupal.assignment1.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.krupal.assignment1.data.model.Content
import com.krupal.assignment1.data.service.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviePagingDataSource constructor(
    private val movieService: MovieService,
    private val query: String?,
) : PagingSource<Int, Content>() {

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Content>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Content> {

        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = withContext(Dispatchers.IO) {
                movieService.getMoviesList(query, page)
            }
            LoadResult.Page(
                data = response.page.contentItems.content,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if ((response.page.pageNum * response.page.pageSize) > response.page.totalContentItems) null else page.plus(
                    1
                )
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}