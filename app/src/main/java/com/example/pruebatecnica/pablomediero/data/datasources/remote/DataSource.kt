package com.example.pruebatecnica.pablomediero.data.datasources.remote

import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    suspend fun getAllUsersData(): Flow<Result<ApiResponse>>
}