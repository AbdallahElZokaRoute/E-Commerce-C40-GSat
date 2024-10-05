package com.route.e_commerce_c40_gsat.Screens.register

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.entity.ApiResult
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity
import com.route.domain.usecases.auth.RegisterUseCase
import com.route.e_commerce_c40_gsat.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    val email = mutableStateOf("")
    val emailError = mutableStateOf("")
    val phone = mutableStateOf("")
    val phoneError = mutableStateOf("")
    val userName = mutableStateOf("")
    val userNameError = mutableStateOf("")
    val password = mutableStateOf("")
    val errorState = mutableStateOf("")
    val showMessage = mutableStateOf(false)
    val showLoading = mutableStateOf(false)
    val passwordError = mutableStateOf("")
    var emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    val navigation: MutableState<Destination> = mutableStateOf(Destination.Register)
    fun validateFields(): Boolean {
        if (email.value.isEmpty() || email.value.isBlank()) {
            emailError.value = "Email Required"
            return false
        } else
            emailError.value = ""
        if (!email.value.matches(emailPattern.toRegex())) {
            emailError.value = "Email Address is wrong Formatted"
            return false
        } else
            emailError.value = ""
        if (password.value.isEmpty() || password.value.isBlank()) {
            passwordError.value = "Password Required"
            return false
        } else
            passwordError.value = ""
        if (password.value.length < 6) {
            passwordError.value = "Password Cannot Be less than 6 chars or digits"
            return false
        } else {
            passwordError.value = ""
        }
        return true
    }

    fun register() {
        if (validateFields())
            viewModelScope.launch {
                showLoading.value = true
                val response =
                    registerUseCase(
                        RegisterRequestEntity(
                            email = email.value,
                            password = password.value,
                            rePassword = password.value,
                            phone = phone.value,
                            name = userName.value
                        )
                    )
                response.collect { result ->


                    when (result) {
                        is ApiResult.Error -> {
                            errorState.value = result.message
                            showMessage.value = true
                        }

                        is ApiResult.Loading -> {
                            showLoading.value = result.showLoading
                        }

                        is ApiResult.Success -> {
                            showMessage.value = false
                            navigation.value = Destination.Home
                        }
                    }

                }
            }
    }

}