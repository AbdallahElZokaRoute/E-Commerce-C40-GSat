package com.route.domain.usecases.auth

import com.route.domain.repostories.AuthRepository
import javax.inject.Inject

class StoreTokenUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(token: String) {
        repository.saveToken(token)
    }
}