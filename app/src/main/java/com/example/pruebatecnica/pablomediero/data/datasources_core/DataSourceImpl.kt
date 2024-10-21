package com.example.pruebatecnica.pablomediero.data.datasources_core

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.ApiService
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class DataSourceImpl(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getAllUsersData(): Flow<Result<ApiResponse>> = flow {
        try {
            val response = apiService.getRandomUsers(results = 10, page = 1)
            emit(Result.success(response))
        } catch (e: HttpException) {
            emit(Result.failure<ApiResponse>(e))
        } catch (e: IOException) {

            emit(Result.failure<ApiResponse>(e))
        } catch (e: Exception) {

            emit(Result.failure<ApiResponse>(e))
        }
     }
}