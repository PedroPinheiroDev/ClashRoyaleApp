package com.example.clashroyaleapplication.presentation.viewmodel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CardsViewModel(get(), get())
    }
    viewModel {
        FavoritesViewModel(get())
    }
}