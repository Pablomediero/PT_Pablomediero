package com.example.pruebatecnica.pablomediero.domain.repository

import com.example.pruebatecnica.pablomediero.data.models.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getAllUsersData(): Flow<Result<List<User>>>
}