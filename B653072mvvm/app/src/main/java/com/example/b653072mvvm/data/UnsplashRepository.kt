package com.example.b653072mvvm.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.b653072mvvm.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor (private val unsplashApi: UnsplashApi) {

    fun getSearchResults(query: String) =
            Pager(
                    config = PagingConfig(
                            pageSize = 20,
                            maxSize = 100,
                            enablePlaceholders = false
                    ),
                    pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
            ).liveData
}