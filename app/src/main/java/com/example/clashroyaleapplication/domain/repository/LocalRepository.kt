package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.data.local.entity.CardLocal
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getAllCardsLocal(): Flow<List<CardLocal>>
    suspend fun insertCards(card: CardLocal)
    suspend fun deleteCards(card: CardLocal)
}