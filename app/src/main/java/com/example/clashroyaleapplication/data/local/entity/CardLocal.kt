package com.example.clashroyaleapplication.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardLocal(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "max_level")
    val maxLevel: Int,
    @ColumnInfo(name = "name")
    val name: String
)