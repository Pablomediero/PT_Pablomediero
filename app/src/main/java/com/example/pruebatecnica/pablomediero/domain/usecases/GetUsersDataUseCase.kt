package com.example.pruebatecnica.pablomediero.domain.usecases

import androidx.paging.PagingData
import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsersDataUseCase(
    private val usersRepository: UsersRepository
){
    operator fun invoke(): Flow<PagingData<User>> = usersRepository.getAllUsersData()
}