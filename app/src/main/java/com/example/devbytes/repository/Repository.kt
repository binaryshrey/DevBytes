package com.example.devbytes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.devbytes.database.DevBytesDatabase
import com.example.devbytes.database.asDomainModel
import com.example.devbytes.domain.Model
import com.example.devbytes.network.DevBytesAPI
import com.example.devbytes.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database : DevBytesDatabase) {

    val videos : LiveData<List<Model>> = Transformations.map(database.databaseDao.getVideos()){
        it.asDomainModel()
    }

    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            val playlist = DevBytesAPI.retrofitService.getProperties().await()
            database.databaseDao.insertAll(*playlist.asDatabaseModel())
        }
    }
}