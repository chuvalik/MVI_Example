package com.example.mvieducationalexample.feature_list.data.remote

import com.example.mvieducationalexample.feature_list.domain.model.Post
import retrofit2.http.GET

interface PlaceholderApi {

    @GET("posts")
    suspend fun fetchPosts(): List<Post>


    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }
}