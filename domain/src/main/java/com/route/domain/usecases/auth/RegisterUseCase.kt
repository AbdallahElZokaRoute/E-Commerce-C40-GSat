package com.route.domain.usecases.auth

import com.route.domain.entity.ApiResult
import com.route.domain.entity.auth.AuthResponseEntity
import com.route.domain.repostories.AuthRepository
import com.route.domain.request.RegisterRequestEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(requestEntity: RegisterRequestEntity): Flow<ApiResult<AuthResponseEntity>> {
        return repository.register(requestEntity)
    }

}