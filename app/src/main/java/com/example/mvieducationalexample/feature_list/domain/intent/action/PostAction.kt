package com.example.mvieducationalexample.feature_list.domain.intent.action

import com.example.mvieducationalexample.core.redux.Action
import com.example.mvieducationalexample.feature_list.domain.model.Post

sealed class PostAction : Action {
    object FetchPosts : PostAction()
    object FetchingPosts: PostAction()
    data class PostsLoaded(val posts: List<Post>): PostAction()
    data class ErrorOccurred(val error: String?): PostAction()
}
