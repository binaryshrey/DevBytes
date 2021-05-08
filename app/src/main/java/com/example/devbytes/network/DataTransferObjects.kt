package com.example.devbytes.network

import com.example.devbytes.database.DatabaseEntity
import com.example.devbytes.domain.Model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DevBytesProperty(val videos: List<Model>)

//extension function that converts from data transfer objects to database objects:

fun DevBytesProperty.asDatabaseModel(): Array<DatabaseEntity> {
    return videos.map {
        DatabaseEntity (
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }.toTypedArray()
}