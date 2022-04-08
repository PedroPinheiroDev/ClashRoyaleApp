package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.local.CardDao
import com.example.clashroyaleapplication.data.local.entity.CardLocal
import com.example.clashroyaleapplication.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalRepositoryImpl(
    private val dao: CardDao
) : LocalRepository {
    override suspend fun getAllCardsLocal(): Flow<List<CardLocal>> = flow {
        dao.getCards().collect {
            emit(it)
        }
    }

    override suspend fun insertCards(card: CardLocal) =
        dao.insertActivity(card)

    override suspend fun deleteCards(card: CardLocal) =
        dao.deleteCard(card)
}