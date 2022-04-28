package com.example.clashroyaleapplication.data.mapper

import com.example.clashroyaleapplication.data.local.entity.CardLocal
import com.example.clashroyaleapplication.domain.entity.Card

class CardToDomainMapper : BaseMapper<List<CardLocal>, List<Card>> {
    override fun invoke(entity: List<CardLocal>): List<Card> {
        return entity.map {
            Card(
                imageUrl = it.imageUrl,
                id = it.id,
                maxLevel = it.maxLevel,
                name = it.name
            )
        }
    }
}