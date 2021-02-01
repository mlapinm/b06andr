package com.example.b653042mvvm.ui.gallery

import android.app.DownloadManager
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope

import com.example.b653042mvvm.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(
        private val repository: UnsplashRepository
) : ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)



    fun searchPhotos(query: String){
        currentQuery.value = query
    }

    companion object{
        private const val DEFAULT_QUERY = "cats"
    }
}