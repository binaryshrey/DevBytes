package com.example.devbytes.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://devbytes.udacity.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DevBytesAPIService{
    @GET("devbytes.json")
    suspend fun getProperties() : DevBytesProperty
}

object DevBytesAPI {
    val retrofitService : DevBytesAPIService by lazy {
        retrofit.create(DevBytesAPIService::class.java)
    }
}