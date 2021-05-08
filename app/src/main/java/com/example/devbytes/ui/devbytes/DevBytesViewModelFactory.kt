package com.example.devbytes.ui.devbytes

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DevBytesViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DevBytesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DevBytesViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}