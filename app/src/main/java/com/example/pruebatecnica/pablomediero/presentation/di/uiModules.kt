package com.example.pruebatecnica.pablomediero.presentation.di

import org.koin.core.module.Module
import org.koin.dsl.module


val uiModule = module {
    presentationModule()
}

private fun Module.presentationModule() {
    //viewModelOf(::MainViewModel)
}