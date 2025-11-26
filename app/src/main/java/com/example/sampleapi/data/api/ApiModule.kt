package com.example.sampleapi.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    val api by lazy {
        Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEndpoint::class.java)
    }

    fun getAPI() = api
}