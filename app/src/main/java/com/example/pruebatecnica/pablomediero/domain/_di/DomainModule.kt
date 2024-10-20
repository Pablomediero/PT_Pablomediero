package com.example.pruebatecnica.pablomediero.domain._di

import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule = module {
    domainModule()
}

private fun Module.domainModule() {
    //singleOf(::UseCase)
}
