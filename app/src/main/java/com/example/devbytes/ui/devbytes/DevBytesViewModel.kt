package com.example.devbytes.ui.devbytes

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.devbytes.network.DevBytesAPI
import com.example.devbytes.network.DevBytesProperty
import kotlinx.coroutines.launch

class DevBytesViewModel(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<DevBytesProperty>()
    val property: LiveData<DevBytesProperty>
        get() = _property

//    init {
//        getVideosFromService()
//
//    }

//    private fun getVideosFromService() {
//        viewModelScope.launch {
//            try {
//                _property.value = DevBytesAPI.retrofitService.getProperties()
////                Log.i("DevBytes", DevBytesAPI.retrofitService.getProperties().videos[0].thumbnail)
//            } catch (e: Exception) {
//                Log.i("DevBytes", e.toString())
//                _property.value = null
//
//            }
//        }
//    }

}