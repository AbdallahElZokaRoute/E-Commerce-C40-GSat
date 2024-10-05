package com.route.e_commerce_c40_gsat.Screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.route.e_commerce_c40_gsat.BottomAppBarTabs
import com.route.e_commerce_c40_gsat.Destination
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.Routes
import com.route.e_commerce_c40_gsat.Screens.register.MyButton
import com.route.e_commerce_c40_gsat.Screens.register.MyRouteImage
import com.route.e_commerce_c40_gsat.Screens.register.MyText

@Composable
fun LoginScreenContent(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.blue))
    ) {
        MyRouteImage(Modifier)
        LoginContent(modifier, navController = navController)
    }
}

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val scrollState = rememberScrollState()
    Column(
        modifier
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        MyText(
            modifier, "  Welcome Back To Route", FontWeight.Bold
        )
        MyText(Modifier, "  Please sign in with your mail", null)
        TemplateBox(
            Modifier
                .padding(0.dp)
                .padding(vertical = 20.dp),
            text = "Email\n",
            placeholder = "enter your Email Address", img = null,
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
            viewModel.login()
        }
        MyText(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Routes.REGISTER_SCREEN)
                },
            "\nDon’t have an account? Create Account",
            null
        )
    }
    ErrorDialog(message = viewModel.errorState.value, showMessage = viewModel.showMessage)
    LaunchedEffect(viewModel.navigation.value) {
        when (viewModel.navigation.value) {
            Destination.Home -> {
                navController.navigate(Routes.HOME_SCREEN)
            }

            Destination.Login -> {}
            Destination.Register -> {
                navController.navigate(Routes.REGISTER_SCREEN)
            }
        }
    }
}

@Composable
fun ErrorDialog(
    message: String,
    showMessage: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    if (showMessage.value)
        AlertDialog(onDismissRequest = {
            showMessage.value = false
        }, confirmButton = {
            TextButton(onClick = { showMessage.value = false }) {
                Text(text = "ok")
            }
        }, text = {
            Text(text = message)
        })
}

@Composable
fun TemplateBox(
    modifier: Modifier = Modifier,
    textValue: MutableState<String>,
    text: String,
    placeholder: String,
    img: Int?,
    error: String
) {
    Column(Modifier.padding(vertical = 15.dp)) {
        Text(text, color = Color.White, fontSize = 20.sp)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue.value,
            onValueChange = { textValue.value = it },
            isError = error.isNotEmpty(),
            placeholder = { Text(text = placeholder) },

            shape = OutlinedTextFieldDefaults.shape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                errorContainerColor = Color.White,
            ),
            leadingIcon = {
                if (img != null) {
                    painterResource(img)
                }
            }
        )
        if (error.isNotEmpty())
            Text(text = error, color = Color.White)
    }
}

