package com.example.pruebatecnica.pablomediero.domain.repository

import androidx.paging.PagingData
import com.example.pruebatecnica.pablomediero.data.models.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getAllUsersData(): Flow<PagingData<User>>
}