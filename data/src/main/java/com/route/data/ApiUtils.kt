package com.route.data

import android.util.Log
import com.google.gson.Gson
import com.route.data.models.auth.AuthResponse
import com.route.domain.entity.ApiResult
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

// Kotlin Flows
// MVI UI Architecture Pattern
// Unit Testing

fun <T> handleException(e: Exception): ApiResult.Error<T> {
    return when (e) {
        is UnknownHostException,
        is IOException,
        -> ApiResult.Error("Connection Error , kindly check your internet connection.")

        is HttpException -> {
            val errorBody =
                Gson().fromJson(
                    e.response()?.errorBody()?.string(),
                    AuthResponse::class.java
                )
            Log.e("TAG", "Exception: ${errorBody.statusMsg}")
            Log.e("TAG", "Exception: ${errorBody.message}")
            ApiResult.Error("${errorBody.message}")
        }

        else -> {
            ApiResult.Error("Something went wrong.")
        }
    }
}

fun <T> executeAPI(api: suspend () -> T) = flow {
    try {
        emit(ApiResult.Loading(true))
        val response = api.invoke()
        emit(ApiResult.Loading(false))
        emit(ApiResult.Success(data = response))
    } catch (e: Exception) {
        emit(ApiResult.Loading(false))
        emit(handleException(e))
    }
}

