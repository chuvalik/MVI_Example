package com.example.mvieducationalexample.feature_list.data.repository

import com.example.mvieducationalexample.core.utils.Resource
import com.example.mvieducationalexample.feature_list.data.remote.PlaceholderApi
import com.example.mvieducationalexample.feature_list.domain.model.Post
import com.example.mvieducationalexample.feature_list.domain.repository.PostRepository
import kotlinx.coroutines.delay

class PostRepositoryImpl(
    private val api: PlaceholderApi
): PostRepository {

    override suspend fun fetchPosts(): Resource<List<Post>> {
        return try {
            delay(1000) // Test purpose
            Resource.Success(api.fetchPosts())
        } catch (e: Exception) {
            Resource.Error(error = e.message)
        }
    }
}