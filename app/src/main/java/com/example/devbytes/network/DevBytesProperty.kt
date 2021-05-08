package com.example.devbytes.network

import com.example.devbytes.domain.Model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DevBytesProperty(val videos: List<Model>)

