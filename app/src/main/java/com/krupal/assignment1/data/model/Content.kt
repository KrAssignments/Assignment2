package com.krupal.assignment1.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("poster-image")
    @Expose
    val posterImage: String
)