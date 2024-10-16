package com.example.pruebatecnica.pablomediero.presentation.ui.di

import android.app.Application
import com.example.pruebatecnica.pablomediero.data.repository.di.dataModule
import com.example.pruebatecnica.pablomediero.domain.usecases.di.domainModule
import com.example.pruebatecnica.pablomediero.presentation.viewmodels.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class PruebaTecnicaApp : Application(){
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@PruebaTecnicaApp)
            modules(
                dataModule,
                domainModule,
                uiModule
            )
        }
    }
}