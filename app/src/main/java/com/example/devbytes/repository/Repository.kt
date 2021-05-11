package com.example.devbytes.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.devbytes.database.DevBytesDatabase
import com.example.devbytes.database.asDomainModel
import com.example.devbytes.domain.Model
import com.example.devbytes.network.DevBytesAPI
import com.example.devbytes.network.asDatabaseModel
import com.example.devbytes.ui.devbytes.DevBytesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class Repository(private val database : DevBytesDatabase) {

    val videos : LiveData<List<Model>> = Transformations.map(database.databaseDao.getVideos()){
        it.asDomainModel()
    }

    suspend fun refreshVideos(){
        withContext(Dispatchers.IO){
            try{
                val playlist = DevBytesAPI.retrofitService.getProperties().await()
                database.databaseDao.insertAll(*playlist.asDatabaseModel())
            }
            catch (e : Exception){
                Log.i("Repository", "${e.message}")
            }

        }
    }
}