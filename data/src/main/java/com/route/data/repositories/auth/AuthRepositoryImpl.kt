package com.route.data.repositories.auth

import com.route.domain.dataSource.AuthOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.repostories.AuthRepository
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity

class AuthRepositoryImpl(
    private val onlineDataSource: AuthOnlineDataSource
) : AuthRepository {
    override suspend fun login(requestEntity: LoginRequestEntity): ApiResult<AuthResponseEntity> {
        return onlineDataSource.login(requestEntity)
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): ApiResult<AuthResponseEntity> {
        return onlineDataSource.register(requestEntity)
    }

}
