package com.route.data.dataSource.online.api.auth

import com.route.data.dataSource.online.api.request.LoginRequest
import com.route.data.dataSource.online.api.request.RegisterRequest
import com.route.data.handleException
import com.route.domain.dataSource.AuthOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity

class AuthOnlineDataSourceImpl(
    private val service: AuthService
) : AuthOnlineDataSource {
    override suspend fun login(requestEntity: LoginRequestEntity): ApiResult<AuthResponseEntity> {
        try {
            val request = LoginRequest(requestEntity.password, requestEntity.email)
            return ApiResult.Success(
                service.login(
                    request
                ).toEntity()
            )
        } catch (e: Exception) {
            return handleException(e)
        }
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): ApiResult<AuthResponseEntity> {
        try {
            val request =
                RegisterRequest(
                    requestEntity.password,
                    requestEntity.phone,
                    requestEntity.rePassword,
                    requestEntity.name,
                    requestEntity.email
                )
            return ApiResult.Success(service.register(request).toEntity())
        } catch (e: Exception) {
            return handleException(e)
        }
    }

}
