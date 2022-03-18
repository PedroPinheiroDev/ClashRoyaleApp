package com.example.clashroyaleapplication.data.remote

import com.example.clashroyaleapplication.data.remote.dto.CardsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ClashApi {
    @GET("cards?limit=106")
    suspend fun getAllCards(): Response<CardsDTO>
}