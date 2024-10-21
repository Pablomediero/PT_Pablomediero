package com.example.pruebatecnica.pablomediero.data._di

import com.example.pruebatecnica.pablomediero.data.datasources.remote.Const.Constants.API_URL
import com.example.pruebatecnica.pablomediero.data.datasources.remote.DataSource
import com.example.pruebatecnica.pablomediero.data.datasources_core.DataSourceImpl
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.ApiService
import com.example.pruebatecnica.pablomediero.data.repository.UsersRepositoryImpl
import com.example.pruebatecnica.pablomediero.domain.repository.UsersRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val dataModule = module {
    remoteInjector()
    dataInjector()
}
private fun Module.dataInjector(){
    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    singleOf(::DataSourceImpl) bind DataSource::class
    singleOf(::UsersRepositoryImpl) bind UsersRepository::class
}

private fun Module.remoteInjector() {

    single {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}