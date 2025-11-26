package com.example.sampleapi.data.api

import com.example.sampleapi.data.model.PostModel
import retrofit2.http.GET

interface ApiEndpoint{
    @GET(ApiDetails.POST_ENDPOINT)
    suspend fun getPost(): PostModel
}