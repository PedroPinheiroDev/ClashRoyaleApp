package com.example.clashroyaleapplication.domain.repository

import com.example.clashroyaleapplication.domain.entity.Card

interface ClashRepository {
    suspend fun getAllRepositories(): List<Card>
}