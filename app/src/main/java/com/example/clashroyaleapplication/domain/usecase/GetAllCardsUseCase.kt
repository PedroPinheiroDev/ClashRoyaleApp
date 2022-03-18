package com.example.clashroyaleapplication.domain.usecase

import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.ClashRepository

interface GetAllCardsUseCase {
    suspend operator fun invoke(): List<Card>
}

class GetAllCardsUseCaseImpl(
    private val clashRepository: ClashRepository
) : GetAllCardsUseCase {
    override suspend fun invoke(): List<Card> {
        return clashRepository.getAllRepositories()
    }
}