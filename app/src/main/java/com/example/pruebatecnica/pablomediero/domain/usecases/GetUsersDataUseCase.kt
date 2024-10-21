package com.example.pruebatecnica.pablomediero.domain.usecases

import com.example.pruebatecnica.pablomediero.data.models.ApiResponse
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class GetUsersDataUseCase(
    private val usersRepository: UsersRepository
){
    suspend operator fun invoke(): Flow<Result<ApiResponse>> {
        Timber.i("USECASE")
        return usersRepository.getAllUsersData()
    }
}