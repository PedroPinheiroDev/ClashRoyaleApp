package com.example.clashroyaleapplication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.clashroyaleapplication.presentation.event.FavoritesEvent
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.presentation.state.FavoritesScreenState
import kotlinx.coroutines.launch

/**
 * Using Dispatchers.IO by default (Defined in [BaseViewModel])
 */

class FavoritesViewModel(
    private val localCardsUseCase: LocalCardsUseCase
) : BaseViewModel() {

    var state by mutableStateOf(FavoritesScreenState())
        private set

    fun getFavoriteCards() {
        launch {
            localCardsUseCase.getAllCards().collect {
                state = if (it.isEmpty()) {
                    state.copy(
                        isEmpty = true
                    )
                } else {
                    state.copy(
                        list = it
                    )
                }
            }
        }
    }

    fun onEvent(event: FavoritesEvent) {
        when (event) {
            is FavoritesEvent.OnClick -> {
                state = state.copy(
                    isDialogOpen = true,
                    card = event.card
                )
            }
            is FavoritesEvent.OnDismissClick -> {
                state = state.copy(
                    isDialogOpen = false,
                    card = Card("", 0, 0, "")
                )
            }
            is FavoritesEvent.OnRemoveClick -> {
                launch {
                    localCardsUseCase.deleteCard(event.card)
                }
            }
        }
    }
}