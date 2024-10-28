package com.example.pruebatecnica.pablomediero.data.repository

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class UsersRepositoryImpl(
    private val dataSource: DataSource
) : UsersRepository {
    override suspend fun getAllUsersData(): Flow<Result<List<User>>> {
        Timber.i("REPOSITORY")
        return dataSource.getAllUsersData().map { result ->
            result.mapCatching { apiResponse ->
                Result.success(filterDuplicates(apiResponse.results))
            }.getOrElse {
                Result.failure(it)
            }
        }
    }

    private fun filterDuplicates(users: List<User>): List<User> {
        return users.distinctBy { user -> "${user.name.first} ${user.name.last} ${user.email}" }
    }
}