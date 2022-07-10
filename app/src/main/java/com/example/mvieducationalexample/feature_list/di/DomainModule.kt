package com.example.mvieducationalexample.feature_list.di

import com.example.mvieducationalexample.core.redux.Reducer
import com.example.mvieducationalexample.core.redux.Store
import com.example.mvieducationalexample.feature_list.domain.intent.action.PostAction
import com.example.mvieducationalexample.feature_list.domain.intent.reducer.PostReducer
import com.example.mvieducationalexample.feature_list.domain.intent.store.PostStore
import com.example.mvieducationalexample.feature_list.presentation.post_list.PostState
import org.koin.dsl.module

val domainModule = module {

    single<Store<PostState, PostAction>> {
        PostStore(
            repository = get(),
            reducer = get()
        )
    }

    single<Reducer<PostState, PostAction>> {
        PostReducer()
    }
}