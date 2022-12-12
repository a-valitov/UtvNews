package com.avalitov.utvnews.network

import com.avalitov.utvnews.data.model.StoriesResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("stories/")
    suspend fun getStories() : StoriesResponse
}