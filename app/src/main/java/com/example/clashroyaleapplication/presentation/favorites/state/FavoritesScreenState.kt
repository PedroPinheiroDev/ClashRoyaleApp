package com.example.clashroyaleapplication.presentation.favorites.state

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.presentation.base.State

data class FavoritesScreenState(
    val isDialogOpen: Boolean = false,
    val isEmpty: Boolean = false,
    val card: Card = Card("", 0, 0, ""),
    val list: List<Card> = emptyList()
) : State