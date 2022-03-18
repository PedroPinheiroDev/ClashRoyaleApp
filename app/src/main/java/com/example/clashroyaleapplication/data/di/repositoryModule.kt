package com.example.clashroyaleapplication.data.di

import androidx.room.Room
import com.example.clashroyaleapplication.data.local.CardDatabase
import com.example.clashroyaleapplication.data.repository.CardRepositoryImpl
import com.example.clashroyaleapplication.data.repository.ClashRepositoryImpl
import com.example.clashroyaleapplication.domain.repository.CardRepository
import com.example.clashroyaleapplication.domain.repository.ClashRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val CARDS_DATABASE = "db_cards"

val repositoryModule = module {
    factory {
        ClashRepositoryImpl(
            get()
        ) as ClashRepository
    }

    factory {
        CardRepositoryImpl(
            get()
        ) as CardRepository
    }

    single {
        get<CardDatabase>().cardDao()
    }

    single {
        Room.databaseBuilder(androidContext(), CardDatabase::class.java, CARDS_DATABASE).build()
    }
}