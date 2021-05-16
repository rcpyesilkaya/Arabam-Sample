package com.example.arabam_sample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadImage", "imageSize")
fun ImageView.setImage(url: String?, imageSize: String) {
    if (!url.isNullOrEmpty()) {
        val urlChange = url.replace("{0}", imageSize)
        this.downloadImageFromUrl(urlChange, getPlaceHolder(this.context))
    }
}