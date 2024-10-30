package com.example.pruebatecnica.pablomediero.data.datasources.remote

import androidx.paging.PagingData
import com.example.pruebatecnica.pablomediero.data.models.User
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getAllUsersData():Flow<PagingData<User>>
}