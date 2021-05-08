package com.example.devbytes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.devbytes.domain.Model

@Entity(tableName = "dev_bytes_video_table")
data class DatabaseEntity(
    @PrimaryKey
    val url : String,
    val title : String,
    val description : String,
    val updated : String,
    val thumbnail : String
)

//extension function which converts from database objects to domain objects

fun List<DatabaseEntity>.asDomainModel() : List<Model>{
    return map {
        Model(
            url = it.url,
            title = it.title,
            thumbnail = it.thumbnail,
            description = it.description,
            updated = it.updated
        )
    }
}