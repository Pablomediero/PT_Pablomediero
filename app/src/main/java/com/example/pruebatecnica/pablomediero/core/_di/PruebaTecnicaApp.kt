package com.example.pruebatecnica.pablomediero.core._di

import android.app.Application
import com.example.pruebatecnica.pablomediero.data._di.dataModule
import com.example.pruebatecnica.pablomediero.domain._di.domainModule
import com.example.pruebatecnica.pablomediero.presentation._di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import timber.log.Timber

class PruebaTecnicaApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
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