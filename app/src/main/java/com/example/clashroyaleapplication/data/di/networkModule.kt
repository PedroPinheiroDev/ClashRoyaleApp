package com.example.clashroyaleapplication.data.di

import com.example.clashroyaleapplication.data.remote.ClashApi
import com.example.clashroyaleapplication.token.Token
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory {
        getClashService(
            get()
        )
    }
    single {
        createClashService()
    }
}

private fun getClashService(retrofit: Retrofit): ClashApi =
    retrofit.create(ClashApi::class.java)

private fun createClashService(): Retrofit = Retrofit.Builder()
    .baseUrl("https://api.clashroyale.com/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(createOkHttpClient())
    .build()

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("Authorization", "Bearer ${Token.TOKEN_CLASH_API}")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()
}