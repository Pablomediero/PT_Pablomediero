package com.example.pruebatecnica.pablomediero.data.repository

import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class UsersRepositoryImpl(
    private val dataSource: DataSource
): UsersRepository {
    override suspend fun getAllUsersData(): Flow<Result<ApiResponse>> {
        Timber.i("REPOSITORY")
        return dataSource.getAllUsersData().map { result ->
            if (result.isSuccess) {
                val apiResponse = result.getOrNull()
                apiResponse?.let {
                    val filteredUsers = filterDuplicates(it.results)
                    val filteredResponse = it.copy(results = filteredUsers)
                    Result.success(filteredResponse)
                } ?: run {
                    Result.failure(Exception("Error al obtener datos"))
                }
            } else {
                result
            }
        }
    }
    private fun filterDuplicates(users: List<User>): List<User> {
        return users.distinctBy { user -> "${user.name.first} ${user.name.last} ${user.email}" }
    }
}


data class ObjetUser(
    val first : String = "",
    val last : String = "",
    val email: String = "",
)