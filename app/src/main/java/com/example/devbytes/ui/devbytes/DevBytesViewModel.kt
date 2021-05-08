package com.example.devbytes.ui.devbytes

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.devbytes.database.DevBytesDatabase.Companion.getDatabaseInstance
import com.example.devbytes.network.DevBytesAPI
import com.example.devbytes.network.DevBytesProperty
import com.example.devbytes.repository.Repository
import kotlinx.coroutines.launch

class DevBytesViewModel(application: Application) : AndroidViewModel(application) {

    enum class APIStatus { LOADING, DONE, FAILURE}

    private val database = getDatabaseInstance(application)
    private val repository = Repository(database)



    init {
        viewModelScope.launch {
            repository.refreshVideos()
        }

    }


    val playlist = repository.videos
//    val status = repository.status


}