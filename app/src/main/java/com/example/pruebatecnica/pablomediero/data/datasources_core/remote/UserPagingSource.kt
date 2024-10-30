package com.example.pruebatecnica.pablomediero.data.datasources_core.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.HttpErrorCodeException.Companion.NO_CONNECTION_ERROR_CODE
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.HttpErrorCodeException.Companion.UNKNOWN_ERROR_CODE
import com.example.pruebatecnica.pablomediero.data.datasources_core.remote.service.ApiService
import com.example.pruebatecnica.pablomediero.data.models.User
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class UserPagingSource(private val apiService: ApiService) :
    PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {

        return try {
            val page = params.key ?: 1
            val response = apiService.getRandomUsers(page)
            val characters = response.results

            val prevKey = if (page > 0) page - 1 else null
            val nextKey = page + 1

            LoadResult.Page(
                data = characters.map { it },
                prevKey = prevKey,
                nextKey = nextKey
            )
        }  catch (e: Exception){
            val errorCode = when(e){
                is HttpException -> e.code()
                is IOException -> NO_CONNECTION_ERROR_CODE
                else -> UNKNOWN_ERROR_CODE
            }
            Timber.e("Network Error Code: $errorCode")
            LoadResult.Error(HttpErrorCodeException(errorCode))
        }

    }

}

class HttpErrorCodeException(val errorCode: Int): Exception(){
    companion object {
        const val NO_CONNECTION_ERROR_CODE = -100
        const val UNKNOWN_ERROR_CODE = -101
    }
}