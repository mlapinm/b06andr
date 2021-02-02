package com.example.b653052mvvm.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.b653052mvvm.di.UnsplashRepository

class GalleryModel @ViewModelInject constructor(
    private val repository: UnsplashRepository
) : ViewModel() {
}