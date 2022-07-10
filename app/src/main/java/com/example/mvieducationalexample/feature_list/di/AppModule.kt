package com.example.mvieducationalexample.feature_list.di

import com.example.mvieducationalexample.feature_list.presentation.post_list.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        PostViewModel(store = get())
    }
}