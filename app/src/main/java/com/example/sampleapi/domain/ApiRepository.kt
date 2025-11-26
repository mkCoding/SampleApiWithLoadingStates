package com.example.sampleapi.domain

import com.example.sampleapi.data.api.ApiModule

class ApiRepository {
    val api = ApiModule.getAPI()
    suspend fun getPost() = api.getPost()
}