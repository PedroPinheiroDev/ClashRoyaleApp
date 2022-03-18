package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.domain.entity.Card

interface CardRepository {
    suspend fun getAllCards(): List<Card>
    suspend fun insertCards(card: Card)
    suspend fun deleteCards(card: Card)
}