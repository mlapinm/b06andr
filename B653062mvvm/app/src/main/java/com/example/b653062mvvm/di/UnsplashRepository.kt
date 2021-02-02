package com.example.b653062mvvm.di

import com.example.b653062mvvm.data.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi) {
}