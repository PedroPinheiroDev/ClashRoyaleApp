package com.example.clashroyaleapplication.data.mapper

import com.example.clashroyaleapplication.data.remote.dto.CardsDTO
import com.example.clashroyaleapplication.domain.entity.Card

class CardMapper : BaseMapper<CardsDTO?, List<Card>> {
    override fun invoke(entity: CardsDTO?): List<Card> {
        return entity?.let { card ->
            card.items.map {
                Card(
                    imageUrl = it.iconUrls.medium,
                    id = it.id,
                    maxLevel = it.maxLevel,
                    name = it.name
                )
            }
        } ?: listOf()
    }
}