package com.example.clashroyaleapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashroyaleapplication.presentation.event.FavoritesEvent
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.presentation.state.CardsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val localCardsUseCase: LocalCardsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(CardsScreenState())
    var state = _state.asStateFlow()

    init {
        getFavoriteCards()
    }

    private fun getFavoriteCards() {
        viewModelScope.launch {
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
                viewModelScope.launch {
                    localCardsUseCase.deleteCard(event.card)
                }
            }
        }
    }
}