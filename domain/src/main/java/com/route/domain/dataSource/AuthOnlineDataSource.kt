package com.route.domain.dataSource

import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow

interface AuthOnlineDataSource {
    suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity>>
    suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity>>
}
