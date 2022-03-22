package com.example.clashroyaleapplication.presentation.viewmodel

import com.example.clashroyaleapplication.presentation.event.FavoritesEvent
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.presentation.state.CardsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Using Dispatchers.IO by default (Defined in [BaseViewModel])
 */

class FavoritesViewModel(
    private val localCardsUseCase: LocalCardsUseCase
) : BaseViewModel() {

    private var _state = MutableStateFlow(CardsScreenState())
    var state = _state.asStateFlow()

    init {
        getFavoriteCards()
    }

    private fun getFavoriteCards() {
        launch {
            localCardsUseCase.getAllCards().collect {
                _state.update { state ->
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
                _state.update { state ->
                    state.copy(
                        isDialogOpen = true,
                        card = event.card
                    )
                }
            }
            is FavoritesEvent.OnDismissClick -> {
                _state.update { state ->
                    state.copy(
                        isDialogOpen = false,
                        card = Card("", 0, 0, "")
                    )
                }
            }
            is FavoritesEvent.OnRemoveClick -> {
                launch {
                    localCardsUseCase.deleteCard(event.card)
                }
            }
        }
    }
}