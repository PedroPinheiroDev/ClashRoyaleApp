package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.domain.entity.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getAllCards(): Flow<List<Card>>
    suspend fun insertCards(card: Card)
    suspend fun deleteCards(card: Card)
}