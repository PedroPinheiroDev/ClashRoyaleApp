package com.example.clashroyaleapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.GetAllCardsUseCase
import com.example.clashroyaleapplication.domain.usecase.LocalCardsUseCase
import com.example.clashroyaleapplication.presentation.event.CardsEvent
import com.example.clashroyaleapplication.presentation.state.CardsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardsViewModel(
    private val getAllUseCase: GetAllCardsUseCase,
    private val cardsUseCase: LocalCardsUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(CardsScreenState())
    var state = _state.asStateFlow()

    init {
        getCards()
    }

    private fun getCards() {
        viewModelScope.launch {
            getAllUseCase()
                .onSuccess {
                    _state.update { state ->
                        state.copy(list = it)
                    }
                }.onFailure {
                    _state.update { state ->
                        state.copy(error = true)
                    }
                }
        }
    }

    fun onEvent(event: CardsEvent) {
        when (event) {
            is CardsEvent.OnClick -> {
                _state.update { state ->
                    state.copy(
                        isDialogOpen = true,
                        card = event.card
                    )
                }
            }
            is CardsEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    cardsUseCase.insertCard(card = event.card)
                }
            }
            is CardsEvent.OnDismissClick -> {
                _state.update { state ->
                    state.copy(
                        isDialogOpen = false,
                        card = Card("", 0, 0, "")
                    )
                }
            }
        }
    }
}