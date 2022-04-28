package com.example.clashroyaleapplication.data.mapper

import com.example.clashroyaleapplication.data.local.entity.CardLocal
import com.example.clashroyaleapplication.domain.entity.Card

class CardToLocalMapper : BaseMapper<Card, CardLocal> {
    override fun invoke(entity: Card): CardLocal {
        return CardLocal(
            id = entity.id,
            imageUrl = entity.imageUrl,
            maxLevel = entity.maxLevel,
            name = entity.name
        )
    }
}