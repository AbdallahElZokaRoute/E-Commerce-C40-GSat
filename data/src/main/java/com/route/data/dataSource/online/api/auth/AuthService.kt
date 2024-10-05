package com.route.data.dataSource.online.api.auth

import com.route.data.dataSource.online.api.request.LoginRequestModel
import com.route.data.dataSource.online.api.request.RegisterRequest
import com.route.data.models.auth.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/signin")
    suspend fun login(@Body request: LoginRequestModel): AuthResponse

    @POST("auth/signup")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
}
