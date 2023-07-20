package com.krupal.assignment1.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("content-items")
    @Expose
    val contentItems: ContentItems,
    @SerializedName("page-num")
    @Expose
    val pageNum: Int,
    @SerializedName("page-size")
    @Expose
    val pageSize: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("total-content-items")
    @Expose
    val totalContentItems: Int
)