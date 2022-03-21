package com.example.clashroyaleapplication.data.repository

import com.example.clashroyaleapplication.data.mapper.CardMapper
import com.example.clashroyaleapplication.data.remote.ClashApi
import com.example.clashroyaleapplication.domain.entity.Card
import com.example.clashroyaleapplication.domain.repository.ClashRepository

class ClashRepositoryImpl(
    private val service: ClashApi
) : ClashRepository {
    override suspend fun getAllRepositories(): Result<List<Card>> =
        runCatching {
            CardMapper().transform(service.getAllCards().body())
        }
}