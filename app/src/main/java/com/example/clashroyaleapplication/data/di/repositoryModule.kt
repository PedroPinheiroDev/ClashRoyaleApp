package com.example.clashroyaleapplication.data.di

import com.example.clashroyaleapplication.data.repository.LocalRepositoryImpl
import com.example.clashroyaleapplication.data.repository.RemoteRepositoryImpl
import com.example.clashroyaleapplication.domain.repository.LocalRepository
import com.example.clashroyaleapplication.domain.repository.RemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        RemoteRepositoryImpl(
            get()
        ) as RemoteRepository
    }

    factory {
        LocalRepositoryImpl(
            get()
        ) as LocalRepository
    }
}