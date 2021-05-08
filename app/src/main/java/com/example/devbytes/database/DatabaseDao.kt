package com.example.devbytes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos : DatabaseEntity)

    @Query("SELECT * FROM dev_bytes_video_table")
    fun getVideos() : LiveData<List<DatabaseEntity>>

}