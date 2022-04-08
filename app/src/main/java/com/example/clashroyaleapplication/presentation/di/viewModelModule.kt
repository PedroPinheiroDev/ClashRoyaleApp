package com.example.clashroyaleapplication.presentation.di

import com.example.clashroyaleapplication.presentation.cards.viewmodel.CardsViewModel
import com.example.clashroyaleapplication.presentation.favorites.viewmodel.FavoritesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CardsViewModel(get(), get())
    }
    viewModel {
        FavoritesViewModel(get(), get())
    }
}