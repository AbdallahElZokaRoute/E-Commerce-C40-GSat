package com.route.e_commerce_c40_gsat.Screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.route.e_commerce_c40_gsat.Destination
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.Routes
import com.route.e_commerce_c40_gsat.Screens.login.ErrorDialog
import com.route.e_commerce_c40_gsat.Screens.login.TemplateBox

@Composable
fun RegisterScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                colorResource(R.color.blue),
            )
            .verticalScroll(scrollState)
    ) {
        MyRouteImage(Modifier)
        RegisterContent(modifier, navController = navController)
        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Column(modifier.padding(10.dp)) {
        MyText(
            modifier, "  Welcome Back To Route", FontWeight.Bold
        )
        MyText(Modifier, "  Please sign Up with your mail", null)
        TemplateBox(
            text = "Username\n",
            placeholder = "enter your name",
            img = null,
            error = viewModel.userNameError.value,
            textValue = viewModel.userName
        )
        TemplateBox(
            Modifier
                .padding(0.dp)
                .padding(vertical = 20.dp), text = "Phone number\n",
            placeholder = "enter your phone number", img = null,
            error = viewModel.phoneError.value,
            textValue = viewModel.phone
        )
        TemplateBox(
            Modifier
                .padding(0.dp)
                .padding(vertical = 20.dp),
            text = "Email Name\n",
            placeholder = "enter your Email address", img = null,
            error = viewModel.emailError.value,
            textValue = viewModel.email
        )
        TemplateBox(
            Modifier.padding(0.dp),
            text = "Password\n",
            placeholder = "enter your Password",
            img = R.drawable.img,
            error = viewModel.passwordError.value,
            textValue = viewModel.password

        )

        MyText(
            Modifier,
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tForgot password\n",
            null
        )
        MyButton(showLoading = viewModel.showLoading) {
            viewModel.register()
        }
    }
    MyText(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        "\nDon’t have an account? Create Account",
        null
    )
    ErrorDialog(message = viewModel.errorState.value, showMessage = viewModel.showMessage)
    LaunchedEffect(viewModel.navigation.value) {
        when (viewModel.navigation.value) {
            Destination.Home -> navController.navigate(Routes.HOME_SCREEN)
            Destination.Login -> {
                navController.navigate(Routes.LOGIN_SCREEN)
            }

            Destination.Register -> {}
        }
    }
}


@Composable
fun MyRouteImage(modifier: Modifier = Modifier) {
    Image(
        painterResource(R.drawable.logo),
        null,
        Modifier
            .padding(vertical = 40.dp)
            .fillMaxWidth()
    )
}

@Composable
fun MyText(modifier: Modifier = Modifier, text: String, weight: FontWeight?) {
    Text(text, modifier = modifier, color = Color.White, fontWeight = weight, fontSize = 20.sp)
}

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    showLoading: MutableState<Boolean>,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        Modifier.fillMaxWidth(),
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        if (showLoading.value) CircularProgressIndicator() else
            Text("Login", color = colorResource(R.color.blue), fontSize = 20.sp)
    }
}
