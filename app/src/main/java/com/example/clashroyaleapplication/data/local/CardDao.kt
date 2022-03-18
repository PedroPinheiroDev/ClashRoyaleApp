package com.example.clashroyaleapplication.data.local

import androidx.room.*
import com.example.clashroyaleapplication.data.local.entity.CardLocal

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivity(card: CardLocal)

    @Query("SELECT * FROM cards")
    suspend fun getCards(): List<CardLocal>

    @Delete
    suspend fun deleteCard(card: CardLocal)
}