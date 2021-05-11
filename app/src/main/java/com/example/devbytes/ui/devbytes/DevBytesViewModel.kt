package com.example.devbytes.ui.devbytes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.devbytes.database.DevBytesDatabase.Companion.getDatabaseInstance
import com.example.devbytes.repository.Repository
import kotlinx.coroutines.launch

class DevBytesViewModel(application: Application) : AndroidViewModel(application) {

    enum class APIStatus { LOADING, DONE, FAILURE }

    private val database = getDatabaseInstance(application)
    private val repository = Repository(database)

    private val _status = MutableLiveData<APIStatus>()
    val status: LiveData<APIStatus>
        get() = _status


    init {
        viewModelScope.launch {
            _status.postValue(APIStatus.LOADING)
            try {
                repository.refreshVideos()
                _status.postValue(APIStatus.DONE)
            } catch (e: Exception) {
                Log.i("Repository", "${e.message}")
                _status.postValue(APIStatus.FAILURE)
            }
        }
    }

    val playlist = repository.videos

}