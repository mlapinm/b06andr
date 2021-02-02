package com.example.b653072mvvm.di

import com.example.b653072mvvm.data.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi) {
}