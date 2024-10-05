package com.route.data.repositories.auth

import com.route.domain.dataSource.AuthOfflineDataSource
import com.route.domain.dataSource.AuthOnlineDataSource
import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.repostories.AuthRepository
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val onlineDataSource: AuthOnlineDataSource,
    private val offlineDataSource: AuthOfflineDataSource
) : AuthRepository {
    override suspend fun login(requestEntity: LoginRequestEntity): Flow<ApiResult<AuthResponseEntity>> {
        return onlineDataSource.login(requestEntity)
    }

    override suspend fun register(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity>> {
        return onlineDataSource.register(requestEntity)
    }

    override suspend fun saveToken(token: String) {
        offlineDataSource.saveToken(token)
    }

    override suspend fun getToken(): String {
        return offlineDataSource.getToken()
    }
}
