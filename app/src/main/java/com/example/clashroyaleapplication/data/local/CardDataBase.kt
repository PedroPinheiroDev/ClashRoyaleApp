package com.example.clashroyaleapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clashroyaleapplication.data.local.entity.CardLocal

@Database(
    entities = [CardLocal::class],
    version = 1
)
abstract class CardDatabase : RoomDatabase() {
    abstract fun cardDao(): CardDao
}