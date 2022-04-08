package com.example.clashroyaleapplication.domain.di

import com.example.clashroyaleapplication.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetAllCardsRemoteUseCaseImpl(
            get()
        ) as GetAllCardsRemoteUseCase
    }
    factory {
        GetAllCardsLocalUseCaseImpl(
            get()
        ) as GetAllCardsLocalUseCase
    }
    factory {
        DeleteCardUseCaseImpl(
            get()
        ) as DeleteCardUseCase
    }
    factory {
        InsertCardUseCaseImpl(
            get()
        ) as InsertCardUseCase
    }
}