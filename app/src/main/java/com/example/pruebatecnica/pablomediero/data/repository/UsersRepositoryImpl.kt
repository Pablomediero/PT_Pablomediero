package com.example.pruebatecnica.pablomediero.data.repository

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class UsersRepositoryImpl(
    private val dataSource: DataSource
): UsersRepository {
    override suspend fun getAllUsersData(): Flow<Result<ApiResponse>> {
        Timber.i("REPOSITORY")
       return dataSource.getAllUsersData()
    }
}