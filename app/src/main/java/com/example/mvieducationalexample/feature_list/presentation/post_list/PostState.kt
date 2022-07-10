package com.example.mvieducationalexample.feature_list.presentation.post_list

import com.example.mvieducationalexample.core.redux.State
import com.example.mvieducationalexample.feature_list.domain.model.Post

data class PostState(
    val data: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
): State