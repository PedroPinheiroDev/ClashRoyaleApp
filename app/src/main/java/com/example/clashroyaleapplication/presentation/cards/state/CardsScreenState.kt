package com.example.clashroyaleapplication.presentation.cards.state

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.presentation.base.State

data class CardsScreenState(
    val isDialogOpen: Boolean = false,
    val error: Boolean = false,
    val card: Card = Card("", 0, 0, ""),
    val list: List<Card> = emptyList()
) : State