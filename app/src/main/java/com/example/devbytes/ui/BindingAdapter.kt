package com.example.devbytes.ui

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.devbytes.ui.devbytes.DevBytesViewModel

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

@BindingAdapter("progressStatus")
fun status(progressBar: ProgressBar, status : DevBytesViewModel.APIStatus?){
    when(status){
        DevBytesViewModel.APIStatus.LOADING ->{
            progressBar.visibility = View.VISIBLE
        }
        DevBytesViewModel.APIStatus.DONE -> {
            progressBar.visibility = View.INVISIBLE
        }
        DevBytesViewModel.APIStatus.FAILURE -> {
            progressBar.visibility = View.INVISIBLE
        }
    }
}

@BindingAdapter("errorStatus")
fun errorStatus(errorTextView: TextView, status: DevBytesViewModel.APIStatus?) {
    when (status) {
        DevBytesViewModel.APIStatus.LOADING -> {
            errorTextView.visibility = View.INVISIBLE
        }
        DevBytesViewModel.APIStatus.DONE -> {
            errorTextView.visibility = View.INVISIBLE
        }
        DevBytesViewModel.APIStatus.FAILURE -> {
            errorTextView.visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("recyclerViewStatus")
fun recyclerViewStatus(recyclerView: RecyclerView, status: DevBytesViewModel.APIStatus?) {
    when (status) {
        DevBytesViewModel.APIStatus.LOADING -> {
            recyclerView.visibility = View.INVISIBLE
        }
        DevBytesViewModel.APIStatus.DONE -> {
            recyclerView.visibility = View.VISIBLE
        }
        DevBytesViewModel.APIStatus.FAILURE -> {
            recyclerView.visibility = View.INVISIBLE
        }
    }
}