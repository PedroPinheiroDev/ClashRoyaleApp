package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.mapper.CardMapper
import com.example.clashroyaleapplication.data.remote.ClashApi
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.RemoteRepository

class RemoteRepositoryImpl(
    private val service: ClashApi,
    private val mapper: CardMapper = CardMapper()
) : RemoteRepository {
    override suspend fun getAllCardsRemoteRepositories(): Result<List<Card>> =
        runCatching {
            mapper(service.getAllCards().body())
        }
}