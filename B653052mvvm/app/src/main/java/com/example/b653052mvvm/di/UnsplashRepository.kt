package com.example.b653052mvvm.di

import com.example.b653052mvvm.data.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi) {
}