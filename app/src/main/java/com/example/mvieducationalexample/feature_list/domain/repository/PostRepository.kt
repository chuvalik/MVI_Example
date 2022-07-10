package com.example.mvieducationalexample.feature_list.domain.repository

import com.example.mvieducationalexample.core.utils.Resource
import com.example.mvieducationalexample.feature_list.domain.model.Post

interface PostRepository {

    suspend fun fetchPosts(): Resource<List<Post>>
}