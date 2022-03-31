package com.example.clashroyaleapplication.data.di

import com.example.clashroyaleapplication.data.repository.CardRepositoryImpl
import com.example.clashroyaleapplication.data.repository.ClashRepositoryImpl
import com.example.clashroyaleapplication.domain.repository.CardRepository
import com.example.clashroyaleapplication.domain.repository.ClashRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        ClashRepositoryImpl(
            get()
        ) as ClashRepository
    }

    factory {
        CardRepositoryImpl(
            get()
        ) as CardRepository
    }
}