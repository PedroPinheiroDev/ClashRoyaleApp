package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.ClashRepository

interface GetAllCardsUseCase {
    suspend operator fun invoke(): Result<List<Card>>
}

class GetAllCardsUseCaseImpl(
    private val clashRepository: ClashRepository
) : GetAllCardsUseCase {
    override suspend fun invoke(): Result<List<Card>> {
        return clashRepository.getAllRepositories()
    }
}