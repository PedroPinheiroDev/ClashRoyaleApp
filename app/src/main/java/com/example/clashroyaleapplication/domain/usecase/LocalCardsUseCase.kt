package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.CardRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface LocalCardsUseCase {
    suspend fun insertCard(card: Card, dispatcher: CoroutineDispatcher = Dispatchers.IO)
    suspend fun deleteCard(card: Card, dispatcher: CoroutineDispatcher = Dispatchers.IO)
    suspend fun getAllCards(dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<List<Card>>
}

class LocalCardsUseCaseImpl(
    private val cardRepository: CardRepository
) : LocalCardsUseCase {
    override suspend fun insertCard(card: Card, dispatcher: CoroutineDispatcher) {
        return withContext(dispatcher) {
            cardRepository.insertCards(card)
        }
    }

    override suspend fun deleteCard(card: Card, dispatcher: CoroutineDispatcher) {
        return withContext(dispatcher) {
            cardRepository.deleteCards(card)
        }
    }

    override suspend fun getAllCards(dispatcher: CoroutineDispatcher): Flow<List<Card>> {
        return withContext(dispatcher) {
            cardRepository.getAllCards()
        }
    }
}