package com.route.domain.dataSource

import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity

interface AuthOnlineDataSource {
    suspend fun login(requestEntity: LoginRequestEntity): ApiResult<AuthResponseEntity>
    suspend fun register(requestEntity: RegisterRequestEntity): ApiResult<AuthResponseEntity>
}
