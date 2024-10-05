package com.route.data.dataSource.online.api.auth

import com.route.data.dataSource.online.api.request.LoginRequestModel
import com.route.data.dataSource.online.api.request.RegisterRequest
import com.route.data.executeAPI
import com.route.data.handleException
import com.route.data.mapper.toModel
import com.route.domain.dataSource.AuthOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow

class AuthOnlineDataSourceImpl(
    private val service: AuthService
) : AuthOnlineDataSource {
    override suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity>> {
        return executeAPI {
            service.login(requestEntity.toModel()).toEntity()
        }
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity>> {
        return executeAPI {
            service.register(requestEntity.toModel()).toEntity()
        }
    }

}
