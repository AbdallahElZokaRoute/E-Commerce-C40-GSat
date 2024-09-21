package com.route.e_commerce_c40_gsat.Screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
        LoginContent(modifier, navController)
    }
}

@Composable
fun LoginContent(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier.padding(10.dp)) {
        MyText(
            modifier, "  Welcome Back To Route", FontWeight.Bold
        )
        MyText(Modifier, "  Please sign in with your mail", null)
        TemplateBox(
            Modifier
                .padding(0.dp)
                .padding(vertical = 20.dp), "User Name\n",
            "enter your name", null
        )
        TemplateBox(
            Modifier.padding(0.dp), "Password\n", "enter your Password", R.drawable.img
        )
        MyText(
            Modifier,
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tForgot password\n",
            null
        )
        MyButton {
            navController.navigate(Routes.HOME_SCREEN)
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
}

@Composable
fun TemplateBox(modifier: Modifier = Modifier, text: String, placeholder: String, img: Int?) {
    Column(Modifier.padding(vertical = 15.dp)) {
        val textValue = remember { mutableStateOf("") }
        Text(text, color = Color.White, fontSize = 20.sp)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue.value,
            onValueChange = { textValue.value = it },

            placeholder = { Text(text = placeholder) },

            shape = OutlinedTextFieldDefaults.shape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White
            ),
            leadingIcon = {
                if (img != null) {
                    painterResource(img)
                }
            }
        )
    }
}

