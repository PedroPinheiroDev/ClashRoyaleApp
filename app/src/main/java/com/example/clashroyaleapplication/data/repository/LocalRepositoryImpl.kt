package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.local.CardDao
import com.example.clashroyaleapplication.data.local.entity.CardLocal
import com.example.clashroyaleapplication.data.mapper.CardToDomainMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalRepositoryImpl(
    private val dao: CardDao,
    private val mapper: CardToDomainMapper = CardToDomainMapper()
) : LocalRepository {
    override suspend fun getAllCardsLocal(): Flow<List<Card>> = flow {
        dao.getCards().collect {
            emit(mapper.transform(it))
        }
    }

    override suspend fun insertCards(card: CardLocal) =
        dao.insertActivity(card)

    override suspend fun deleteCards(card: CardLocal) =
        dao.deleteCard(card)
}