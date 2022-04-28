package com.example.clashroyaleapplication.presentation.features.cards.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.GetAllCardsRemoteUseCase
import com.example.clashroyaleapplication.domain.usecase.InsertCardUseCase
import com.example.clashroyaleapplication.presentation.base.BaseViewModel
import com.example.clashroyaleapplication.presentation.features.cards.event.CardsScreenEvent
import com.example.clashroyaleapplication.presentation.features.cards.state.CardsScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CardsViewModel(
    private val getAllUseCase: GetAllCardsRemoteUseCase,
    private val insertCardUseCase: InsertCardUseCase
) : BaseViewModel<CardsScreenEvent, CardsScreenState>() {

    private val _state = MutableStateFlow(CardsScreenState())
    override val state = _state.asStateFlow()

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

    override fun onEvent(event: CardsScreenEvent) {
        when (event) {
            is CardsScreenEvent.OnClick -> {
                _state.update { state ->
                    state.copy(
                        isDialogOpen = true,
                        card = event.card
                    )
                }
            }
            is CardsScreenEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    insertCardUseCase(card = event.card)
                }
            }
            is CardsScreenEvent.OnDismissClick -> {
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