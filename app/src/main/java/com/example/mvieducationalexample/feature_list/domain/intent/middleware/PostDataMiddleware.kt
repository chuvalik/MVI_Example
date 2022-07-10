package com.example.mvieducationalexample.feature_list.domain.intent.middleware

import com.example.mvieducationalexample.core.redux.Middleware
import com.example.mvieducationalexample.core.redux.Store
import com.example.mvieducationalexample.core.utils.Resource
import com.example.mvieducationalexample.feature_list.domain.intent.action.PostAction
import com.example.mvieducationalexample.feature_list.domain.repository.PostRepository
import com.example.mvieducationalexample.feature_list.presentation.post_list.PostState

class PostDataMiddleware(
    private val repository: PostRepository
) : Middleware<PostState, PostAction> {

    override suspend fun process(
        action: PostAction,
        currentState: PostState,
        store: Store<PostState, PostAction>
    ) {
        when (action) {
            is PostAction.FetchPosts -> fetchPosts(store)
        }
    }

    private suspend fun fetchPosts(store: Store<PostState, PostAction>) {

        store.dispatch(PostAction.FetchingPosts)

        when (val event = repository.fetchPosts()) {
            is Resource.Error -> {
                store.dispatch(PostAction.ErrorOccurred(event.error))
            }
            is Resource.Success -> store.dispatch(
                PostAction.PostsLoaded(
                    event.data ?: emptyList()
                )
            )
            else -> Unit
        }
    }
}