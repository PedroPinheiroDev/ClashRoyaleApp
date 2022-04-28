package com.example.clashroyaleapplication.presentation.favorites.event

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.presentation.base.Event

sealed class FavoritesEvent : Event {
    data class OnClick(val card: Card) : FavoritesEvent()
    data class OnRemoveClick(val card: Card) : FavoritesEvent()
    object OnDismissClick : FavoritesEvent()
}