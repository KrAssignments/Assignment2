package com.krupal.assignment1.data.service

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.krupal.assignment1.data.model.ApiResponse
import java.io.BufferedReader
import javax.inject.Inject

class AssetsMovieServiceImpl @Inject constructor(
    private val application: Application,
) : MovieService {

    private val gson: Gson = GsonBuilder()
        .setPrettyPrinting()
        .enableComplexMapKeySerialization()
        .setLenient()
        .create()

    private fun openAssetFile(pageNo: Int): String? {
        return try {
            val content = StringBuilder()
            val iStream = BufferedReader(
                application.assets.open("CONTENTLISTINGPAGE-PAGE${pageNo}.json").reader()
            )
            var line: String?
            do {
                line = iStream.readLine()
                line?.let { content.append(it) }
            } while (line != null)
            content.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    override fun getMoviesList(searchKey: String?, pageNo: Int): ApiResponse {
        val readString = openAssetFile(pageNo)
        val contentClass = gson.fromJson(readString, ApiResponse::class.java)
        return ApiResponse(contentClass.page).apply {
            this.page.contentItems.content = this.page.contentItems.content.filter {
                if (searchKey.isNullOrBlank() || searchKey.length < 3) true else it.name.contains(
                    searchKey,
                    ignoreCase = true
                )
            }
        }
    }
}