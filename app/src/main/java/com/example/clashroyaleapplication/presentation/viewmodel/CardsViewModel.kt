package com.example.clashroyaleapplication.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.GetAllCardsUseCase
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.presentation.event.CardsEvent
import com.example.clashroyaleapplication.presentation.state.CardsScreenState
import kotlinx.coroutines.launch

/**
 * Using Dispatchers.IO by default (Defined in [BaseViewModel])
 */

class CardsViewModel(
    private val getAllUseCase: GetAllCardsUseCase,
    private val cardsUseCase: LocalCardsUseCase
) : BaseViewModel() {

    var state by mutableStateOf(CardsScreenState())
        private set

    fun getCards() {
        launch {
            state = state.copy(
                list = getAllUseCase(),
                isLoading = false
            )
        }
    }

    fun onEvent(event: CardsEvent) {
        when (event) {
            is CardsEvent.OnClick -> {
                state = state.copy(
                    isDialogOpen = true,
                    card = event.card
                )
            }
            is CardsEvent.OnFavoriteClick -> {
                launch {
                    cardsUseCase.insertCard(card = event.card)
                }
            }
            is CardsEvent.OnDismissClick -> {
                state = state.copy(
                    isDialogOpen = false,
                    card = Card("", 0, 0, "")
                )
            }
        }
    }
}