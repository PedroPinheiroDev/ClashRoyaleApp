package com.example.clashroyaleapplication.presentation.favorites.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.usecase.DeleteCardUseCase
import com.example.clashroyaleapplication.domain.usecase.GetAllCardsLocalUseCase
import com.example.clashroyaleapplication.presentation.base.BaseViewModel
import com.example.clashroyaleapplication.presentation.favorites.event.FavoritesEvent
import com.example.clashroyaleapplication.presentation.favorites.state.FavoritesScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getAllLocalCards: GetAllCardsLocalUseCase,
    private val deleteCardUseCase: DeleteCardUseCase
) : BaseViewModel<FavoritesEvent, FavoritesScreenState>() {

    private val _state = MutableStateFlow(FavoritesScreenState())
    override val state = _state.asStateFlow()

    init {
        getFavoriteCards()
    }

    private fun getFavoriteCards() {
        viewModelScope.launch {
            getAllLocalCards().collect {
                _state.update { state ->
                    state.copy(
                        list = it
                    )
                }
            }
        }
    }

    override fun onEvent(event: FavoritesEvent) {
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
                    deleteCardUseCase(event.card)
                }
            }
        }
    }
}