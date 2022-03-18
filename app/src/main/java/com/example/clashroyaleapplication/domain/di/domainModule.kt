package com.example.clashroyaleapplication.domain.di

import com.example.clashroyaleapplication.domain.usecase.GetAllCardsUseCase
import com.example.clashroyaleapplication.domain.usecase.GetAllCardsUseCaseImpl
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetAllCardsUseCaseImpl(
            get()
        ) as GetAllCardsUseCase
    }
    factory {
        LocalCardsUseCaseImpl(
            get()
        ) as LocalCardsUseCase
    }
}