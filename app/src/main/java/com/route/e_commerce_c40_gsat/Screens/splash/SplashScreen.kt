package com.route.e_commerce_c40_gsat.Screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.Routes
import com.route.e_commerce_c40_gsat.ui.theme.Blue1
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController, modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getToken()
        delay(2000)
        val destination =
            if (viewModel.tokenState.value.isEmpty()) Routes.LOGIN_SCREEN else Routes.HOME_SCREEN
        navController.navigate(destination)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue1),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.logo_image)
        )

    }
}

