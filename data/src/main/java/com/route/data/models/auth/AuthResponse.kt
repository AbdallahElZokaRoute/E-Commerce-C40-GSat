package com.route.data.models.auth

import com.google.gson.annotations.SerializedName
import com.route.domain.entity.auth.AuthResponseEntity

data class AuthResponse(

    @field:SerializedName("statusMsg")
    val statusMsg: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("token")
    val token: String? = null
) {
    fun toEntity(): AuthResponseEntity {
        return AuthResponseEntity(
            statusMsg, message, token
        )
    }
}
