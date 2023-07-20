package com.krupal.assignment1.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContentItems(
    @SerializedName("content")
    @Expose
    val content: List<Content>
)