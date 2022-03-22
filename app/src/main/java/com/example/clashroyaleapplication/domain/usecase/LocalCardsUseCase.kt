package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

interface LocalCardsUseCase {
    suspend fun insertCard(card: Card)
    suspend fun deleteCard(card: Card)
    suspend fun getAllCards(): Flow<List<Card>>
}

class LocalCardsUseCaseImpl(
    private val cardRepository: CardRepository
) : LocalCardsUseCase {
    override suspend fun insertCard(card: Card) {
        return cardRepository.insertCards(card)
    }

    override suspend fun deleteCard(card: Card) {
        return withContext(coroutineContext) { cardRepository.deleteCards(card) }
    }

    override suspend fun getAllCards(): Flow<List<Card>> {
        return cardRepository.getAllCards()
    }
}