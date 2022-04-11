package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.domain.entity.Card

interface RemoteRepository {
    suspend fun getAllCardsRemoteRepositories(): Result<List<Card>>
}