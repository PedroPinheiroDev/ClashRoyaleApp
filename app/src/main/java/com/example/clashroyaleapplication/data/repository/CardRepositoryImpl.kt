package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.local.CardDao
import com.example.clashroyaleapplication.data.mapper.CardDomainMapper
import com.example.clashroyaleapplication.data.mapper.CardLocalMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CardRepositoryImpl(
    private val dao: CardDao
) : CardRepository {
    override suspend fun getAllCards(): Flow<List<Card>> = flow {
        dao.getCards().collect {
            emit(CardDomainMapper().transform(it))
        }
    }

    override suspend fun insertCards(card: Card) =
        dao.insertActivity(CardLocalMapper().transform(card))

    override suspend fun deleteCards(card: Card) =
        dao.deleteCard(CardLocalMapper().transform(card))
}