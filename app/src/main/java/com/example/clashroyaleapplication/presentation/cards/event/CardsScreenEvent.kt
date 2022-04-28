package com.example.clashroyaleapplication.presentation.cards.event

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.presentation.base.Event

sealed class CardsScreenEvent : Event {
    data class OnFavoriteClick(val card: Card) : CardsScreenEvent()
    data class OnClick(val card: Card) : CardsScreenEvent()
    object OnDismissClick : CardsScreenEvent()
}