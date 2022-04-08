package com.example.clashroyaleapplication.presentation.favorites.event

import com.example.clashroyaleapplication.domain.entity.Card

sealed class FavoritesEvent {
    data class OnClick(val card: Card) : FavoritesEvent()
    data class OnRemoveClick(val card: Card) : FavoritesEvent()
    object OnDismissClick : FavoritesEvent()
}