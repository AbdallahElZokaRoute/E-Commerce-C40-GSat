package com.route.domain.request

data class RegisterRequestEntity(
	val password: String? = null,
	val phone: String? = null,
	val rePassword: String? = null,
	val name: String? = null,
	val email: String? = null
)

