package com.example.devbytes.network

import com.example.devbytes.domain.Models
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DevBytesProperty(val videos : List<Models>)

