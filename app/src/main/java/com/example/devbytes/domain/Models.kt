package com.example.devbytes.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Models(
    val url : String,
    val title : String,
    val description : String,
    val updated : String,
    val thumbnail : String
) : Parcelable
