package com.example.mvieducationalexample.feature_list.presentation.post_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvieducationalexample.core.redux.Store
import com.example.mvieducationalexample.feature_list.domain.intent.action.PostAction
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val store: Store<PostState, PostAction>
) : ViewModel() {

    val viewState: StateFlow<PostState> = store.state

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            store.dispatch(PostAction.FetchPosts)
        }
    }
}