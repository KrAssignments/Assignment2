package com.krupal.assignment1.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("content-items")
    @Expose
    var contentItems: ContentItems,
    @SerializedName("page-num")
    @Expose
    var pageNum: Int,
    @SerializedName("page-size")
    @Expose
    var pageSize: Int,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("total-content-items")
    @Expose
    var totalContentItems: Int
)