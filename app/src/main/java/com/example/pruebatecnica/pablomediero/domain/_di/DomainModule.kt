package com.example.pruebatecnica.pablomediero.domain._di

import com.example.pruebatecnica.pablomediero.domain.usecases.GetUsersDataUseCase
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    useCaseInjector()
}

private fun Module.useCaseInjector() {
    singleOf(::GetUsersDataUseCase)
}
