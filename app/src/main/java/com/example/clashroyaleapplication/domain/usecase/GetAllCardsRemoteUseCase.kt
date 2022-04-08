package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.data.mapper.CardMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.RemoteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetAllCardsRemoteUseCase {
    suspend operator fun invoke(dispatcher: CoroutineDispatcher = Dispatchers.IO): Result<List<Card>>
}

class GetAllCardsRemoteUseCaseImpl(
    private val clashRepository: RemoteRepository,
    private val mapper: CardMapper = CardMapper()
) : GetAllCardsRemoteUseCase {
    override suspend fun invoke(dispatcher: CoroutineDispatcher): Result<List<Card>> {
        return withContext(dispatcher) {
            clashRepository.getAllCardsRemoteRepositories().map {
                mapper.transform(it)
            }
        }
    }
}