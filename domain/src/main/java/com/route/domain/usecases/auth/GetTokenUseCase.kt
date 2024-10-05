package com.route.domain.usecases.auth

import com.route.domain.repostories.AuthRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): String {
        return repository.getToken()
    }
}