package com.example.clashroyaleapplication.presentation.state

import com.example.clashroyaleapplication.domain.entity.Card

data class FavoritesScreenState(
    val isDialogOpen: Boolean = false,
    val isEmpty: Boolean = false,
    val card: Card = Card("", 0, 0, ""),
    val list: List<Card> = emptyList()
)