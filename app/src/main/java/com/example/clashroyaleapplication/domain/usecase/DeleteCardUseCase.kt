package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.data.mapper.CardToLocalMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.LocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface DeleteCardUseCase {
    suspend operator fun invoke(card: Card, dispatcher: CoroutineDispatcher = Dispatchers.IO)
}

class DeleteCardUseCaseImpl(
    private val cardRepository: LocalRepository,
    private val mapper: CardToLocalMapper = CardToLocalMapper()
) : DeleteCardUseCase {
    override suspend operator fun invoke(card: Card, dispatcher: CoroutineDispatcher) {
        return withContext(dispatcher) {
            cardRepository.deleteCards(mapper(card))
        }
    }
}