package com.example.pruebatecnica.pablomediero.core.di

import android.app.Application
import com.example.pruebatecnica.pablomediero.data.di.dataModule
import com.example.pruebatecnica.pablomediero.domain.di.domainModule
import com.example.pruebatecnica.pablomediero.presentation.di.uiModule
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