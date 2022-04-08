package com.example.clashroyaleapplication.presentation.cards.event

import com.example.clashroyaleapplication.domain.entity.Card

sealed class CardsScreenEvent {
    data class OnFavoriteClick(val card: Card) : CardsScreenEvent()
    data class OnClick(val card: Card) : CardsScreenEvent()
    object OnDismissClick : CardsScreenEvent()
}