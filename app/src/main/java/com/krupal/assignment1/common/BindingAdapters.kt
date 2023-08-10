package com.krupal.assignment1.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url.isNullOrBlank()) return
    Glide.with(this).load(url).into(this)
}

@BindingAdapter("imageUrl")
fun ImageView.loadImage(drawableRes: Int?) {
    if (drawableRes == null) return
    Glide.with(this).load(drawableRes).into(this)
}