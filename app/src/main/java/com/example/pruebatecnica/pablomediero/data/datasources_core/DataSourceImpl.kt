package com.example.pruebatecnica.pablomediero.data.datasources_core

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.UserPagingSource
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.service.ApiService
import com.example.pruebatecnica.pablomediero.data.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataSourceImpl(
    private val apiService: ApiService
) : DataSource {
    companion object{
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    override  fun getAllUsersData(): Flow<PagingData<User>> = flow {
         Result.success(Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                UserPagingSource(apiService = apiService )
            }))
    }
}
