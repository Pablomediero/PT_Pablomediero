package com.example.pruebatecnica.pablomediero.data.datasources_core

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.datasources_core.HttpErrorCodeException.Companion.NO_CONNECTION_ERROR_CODE
import com.example.pruebatecnica.pablomediero.data.datasources_core.HttpErrorCodeException.Companion.UNKNOWN_ERROR_CODE
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.service.ApiService
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber

class DataSourceImpl(
    private val apiService: ApiService
) : DataSource {
    override suspend fun getAllUsersData(): Flow<Result<ApiResponse>> = flow {
        try {
            emit(Result.success(apiService.getRandomUsers(results = 10, page = 1)))
        } catch (e: Exception){
            val errorCode = when(e){
                is HttpException -> e.code()
                is IOException -> NO_CONNECTION_ERROR_CODE
                else -> UNKNOWN_ERROR_CODE
            }
            Timber.e("Network Error Code: $errorCode")
            emit(Result.failure(HttpErrorCodeException(errorCode)))
        }
     }.flowOn(Dispatchers.IO)
}
class HttpErrorCodeException(val errorCode: Int): Exception(){
    companion object {
        const val NO_CONNECTION_ERROR_CODE = -100
        const val UNKNOWN_ERROR_CODE = -101
    }
}