package com.example.pruebatecnica.pablomediero.data.repository

import androidx.paging.PagingData
import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class UsersRepositoryImpl(
    private val dataSource: DataSource
) : UsersRepository {
    override fun getAllUsersData(): Flow<PagingData<User>> {
        Timber.i("REPOSITORY")
        return dataSource.getAllUsersData()
        }
    }

    private fun filterDuplicates(users: List<User>): List<User> {
        return users.distinctBy { user -> "${user.name.first} ${user.name.last} ${user.email}" }
    }
