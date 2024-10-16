package com.example.pruebatecnica.pablomediero.data.repository.di

import org.koin.core.module.Module
import org.koin.dsl.module


val dataModule = module {
    dataModule()
}

private fun Module.dataModule() {
    //singleOf(::RepositoryImpl) bind Repository::class
}