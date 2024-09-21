package com.route.domain.repostories

import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity

interface AuthRepository {
    suspend fun login(requestEntity: LoginRequestEntity): ApiResult<AuthResponseEntity>
    suspend fun register(requestEntity: RegisterRequestEntity): ApiResult<AuthResponseEntity>
}
