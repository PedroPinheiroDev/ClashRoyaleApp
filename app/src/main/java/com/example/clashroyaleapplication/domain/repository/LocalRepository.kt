package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.data.local.entity.CardLocal
import com.example.clashroyaleapplication.domain.entity.Card
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getAllCardsLocal(): Flow<List<Card>>
    suspend fun insertCards(card: CardLocal)
    suspend fun deleteCards(card: CardLocal)
}