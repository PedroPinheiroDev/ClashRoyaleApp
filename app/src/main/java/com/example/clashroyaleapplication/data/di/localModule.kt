package com.example.clashroyaleapplication.data.di

import androidx.room.Room
import com.example.clashroyaleapplication.data.local.CardDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val CARDS_DATABASE = "db_cards"

val localModule = module {
    single {
        get<CardDatabase>().cardDao()
    }

    single {
        Room.databaseBuilder(androidContext(), CardDatabase::class.java, CARDS_DATABASE).build()
    }
}