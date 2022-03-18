package com.example.clashroyaleapplication.presentation.event

import com.example.clashroyaleapplication.domain.entity.Card

sealed class CardsEvent {
    data class OnFavoriteClick(val card: Card) : CardsEvent()
    data class OnClick(val card: Card) : CardsEvent()
    object OnDismissClick : CardsEvent()
}