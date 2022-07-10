package com.example.mvieducationalexample.feature_list.domain.intent.reducer

import com.example.mvieducationalexample.core.redux.Reducer
import com.example.mvieducationalexample.feature_list.domain.intent.action.PostAction
import com.example.mvieducationalexample.feature_list.presentation.post_list.PostState

class PostReducer : Reducer<PostState, PostAction> {

    override suspend fun reduce(currentState: PostState, action: PostAction): PostState {
        return when (action) {
            is PostAction.FetchingPosts -> {
                currentState.copy(isLoading = true)
            }
            is PostAction.PostsLoaded -> {
                currentState.copy(
                    data = action.posts,
                    isLoading = false
                )
            }
            else -> currentState
        }
    }
}