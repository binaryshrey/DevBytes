package com.example.devbytes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DevBytesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(videos : DevBytesEntity)

    @Query("SELECT * FROM dev_bytes_video_table")
    fun getVideos() : List<DevBytesEntity>

}