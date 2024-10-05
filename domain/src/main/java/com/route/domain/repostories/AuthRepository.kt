package com.route.domain.repostories

import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity>>
    suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity>>
    suspend fun saveToken(token: String)
    suspend fun getToken(): String
}
