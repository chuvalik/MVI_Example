package com.example.mvieducationalexample

import android.app.Application
import com.example.mvieducationalexample.feature_list.di.appModule
import com.example.mvieducationalexample.feature_list.di.dataModule
import com.example.mvieducationalexample.feature_list.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PostApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PostApplication)
            modules(appModule, dataModule, domainModule)
        }
    }
}