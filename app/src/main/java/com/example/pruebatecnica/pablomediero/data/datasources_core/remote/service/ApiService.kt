package com.example.pruebatecnica.pablomediero.data.datasources_core.remote.service

import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") results: Int = 50,
        @Query("page") page: Int = 1
    ): ApiResponse
}