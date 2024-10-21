package com.example.pruebatecnica.pablomediero.presentation._di

import com.example.pruebatecnica.pablomediero.presentation.viewmodels.UserViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val uiModule = module {
    presentationModule()
}

private fun Module.presentationModule() {
    viewModelOf(::UserViewModel)
}