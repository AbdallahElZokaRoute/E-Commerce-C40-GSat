package com.route.e_commerce_c40_gsat.Screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.usecases.auth.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {
    val tokenState = mutableStateOf("")
    fun getToken() {
        viewModelScope.launch {
            try {
                val token = getTokenUseCase()
                tokenState.value = token
            } catch (e: Exception) {
                tokenState.value = ""
            }
        }

    }

}
