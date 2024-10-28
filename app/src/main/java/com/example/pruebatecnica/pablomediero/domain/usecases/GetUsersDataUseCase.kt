package com.example.pruebatecnica.pablomediero.domain.usecases

import com.example.pruebatecnica.pablomediero.data.models.User
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsersDataUseCase(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(): Flow<Result<List<User>>> = usersRepository.getAllUsersData()
}