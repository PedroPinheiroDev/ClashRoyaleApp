package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.ClashRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetAllCardsUseCase {
    suspend operator fun invoke(dispatcher: CoroutineDispatcher = Dispatchers.IO): Result<List<Card>>
}

class GetAllCardsUseCaseImpl(
    private val clashRepository: ClashRepository
) : GetAllCardsUseCase {
    override suspend fun invoke(dispatcher: CoroutineDispatcher): Result<List<Card>> {
        return withContext(dispatcher) { clashRepository.getAllRepositories() }
    }
}