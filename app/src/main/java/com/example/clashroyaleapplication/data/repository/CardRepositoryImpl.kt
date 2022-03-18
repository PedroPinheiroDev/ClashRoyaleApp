package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.local.CardDao
import com.example.clashroyaleapplication.data.mapper.CardDomainMapper
import com.example.clashroyaleapplication.data.mapper.CardLocalMapper
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.CardRepository

class CardRepositoryImpl(
    private val dao: CardDao
) : CardRepository {
    override suspend fun getAllCards(): List<Card> {
        return runCatching {
            CardDomainMapper().transform(dao.getCards())
        }.getOrThrow()
    }

    override suspend fun insertCards(card: Card) {
        runCatching {
            dao.insertActivity(CardLocalMapper().transform(card))
        }.getOrThrow()
    }

    override suspend fun deleteCards(card: Card) {
        runCatching {
            dao.deleteCard(CardLocalMapper().transform(card))
        }.getOrThrow()
    }
}