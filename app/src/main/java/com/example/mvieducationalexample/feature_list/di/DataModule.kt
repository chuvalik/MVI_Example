package com.example.mvieducationalexample.feature_list.di

import com.example.mvieducationalexample.feature_list.data.remote.PlaceholderApi
import com.example.mvieducationalexample.feature_list.data.repository.PostRepositoryImpl
import com.example.mvieducationalexample.feature_list.domain.repository.PostRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<PostRepository> {
        PostRepositoryImpl(api = get())
    }

    single<PlaceholderApi> {
        Retrofit.Builder()
            .baseUrl(PlaceholderApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlaceholderApi::class.java)
    }
}