package com.example.clashroyaleapplication

import android.app.Application
import com.example.clashroyaleapplication.data.di.remoteModule
import com.example.clashroyaleapplication.data.di.localModule
import com.example.clashroyaleapplication.data.di.repositoryModule
import com.example.clashroyaleapplication.domain.di.domainModule
import com.example.clashroyaleapplication.presentation.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    domainModule,
                    remoteModule,
                    localModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}