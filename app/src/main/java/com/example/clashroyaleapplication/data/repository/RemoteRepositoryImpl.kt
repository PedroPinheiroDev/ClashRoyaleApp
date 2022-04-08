package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.remote.ClashApi
import com.example.clashroyaleapplication.data.remote.dto.CardsDTO
import com.example.clashroyaleapplication.domain.repository.RemoteRepository

class RemoteRepositoryImpl(
    private val service: ClashApi
) : RemoteRepository {
    override suspend fun getAllCardsRemoteRepositories(): Result<CardsDTO?> =
        runCatching {
            service.getAllCards().body()
        }
}