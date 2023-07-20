package com.krupal.assignment1.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("page")
    @Expose
    val page: Page
)