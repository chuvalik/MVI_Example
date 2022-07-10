package com.example.mvieducationalexample.feature_list.domain.intent.store

import com.example.mvieducationalexample.core.redux.BaseStore
import com.example.mvieducationalexample.core.redux.LoggingMiddleware
import com.example.mvieducationalexample.core.redux.Reducer
import com.example.mvieducationalexample.feature_list.domain.intent.action.PostAction
import com.example.mvieducationalexample.feature_list.domain.intent.middleware.PostDataMiddleware
import com.example.mvieducationalexample.feature_list.domain.intent.reducer.PostReducer
import com.example.mvieducationalexample.feature_list.domain.repository.PostRepository
import com.example.mvieducationalexample.feature_list.presentation.post_list.PostState

class PostStore(
    repository: PostRepository,
    reducer: Reducer<PostState, PostAction>
): BaseStore<PostState, PostAction>(
    initialState = PostState(),
    reducer = reducer,
    middlewares = listOf(
        LoggingMiddleware(),
        PostDataMiddleware(repository)
    )
) {
}