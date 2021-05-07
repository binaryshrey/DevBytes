package com.example.devbytes.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dev_bytes_video_table")
data class DevBytesEntity(
    @PrimaryKey(autoGenerate = true)
    val url : String,
    val title : String,
    val description : String,
    val updated : String,
    val thumbnail : String
)