package com.avalitov.utvnews.network

import com.avalitov.utvnews.data.model.StoriesResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WebRepository {

    private val retrofit: ApiInterface = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)

    companion object {
        private const val TAG = "WEB_REPO"
        private const val BASE_URL = "https://utv.ru/api/v0/"
    }

    suspend fun loadStories(): StoriesResponse {
        return retrofit.getStories()
    }
}