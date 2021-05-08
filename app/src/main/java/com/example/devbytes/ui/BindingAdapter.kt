package com.example.devbytes.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun bind(image: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(image.context)
            .load(imgUri)
            .into(image)
    }
}

@BindingAdapter("title")
fun setTitle(videoTitle: TextView, title: String?) {
    title?.let {
        videoTitle.text = it
    }
}

@BindingAdapter("description")
fun setDescription(videoDescription: TextView, description: String?) {
    description?.let {
        videoDescription.text = it
    }
}