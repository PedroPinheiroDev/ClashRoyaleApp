package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.data.mapper.CardToDomainMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.LocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

interface GetAllCardsLocalUseCase {
    suspend operator fun invoke(dispatcher: CoroutineDispatcher = Dispatchers.IO): Flow<List<Card>>
}

class GetAllCardsLocalUseCaseImpl(
    private val cardRepository: LocalRepository,
    private val mapper: CardToDomainMapper = CardToDomainMapper()
) : GetAllCardsLocalUseCase {

    override suspend operator fun invoke(dispatcher: CoroutineDispatcher): Flow<List<Card>> {
        return withContext(dispatcher) {
            cardRepository.getAllCardsLocal().map {
                mapper.transform(it)
            }
        }
    }
}