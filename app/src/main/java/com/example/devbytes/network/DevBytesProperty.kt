package com.example.devbytes.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DevBytesProperty(
    val url : String,
    val title : String,
    val description : String,
    val updated : String,
    val thumbnail : String
) : Parcelable