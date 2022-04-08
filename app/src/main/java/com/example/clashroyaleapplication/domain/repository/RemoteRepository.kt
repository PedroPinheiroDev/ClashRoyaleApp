package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.data.remote.dto.CardsDTO

interface RemoteRepository {
    suspend fun getAllCardsRemoteRepositories(): Result<CardsDTO?>
}