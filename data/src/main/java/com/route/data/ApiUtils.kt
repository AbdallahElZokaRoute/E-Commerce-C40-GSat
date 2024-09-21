package com.route.data

import android.util.Log
import com.google.gson.Gson
import com.route.data.models.auth.AuthResponse
import com.route.domain.entity.ApiResult
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

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
            Log.e("TAG", "login: ${errorBody.statusMsg}")
            Log.e("TAG", "login: ${errorBody.message}")
            ApiResult.Error("${errorBody.message}")
        }

        else -> {
            ApiResult.Error("Something went wrong.")
        }
    }
}