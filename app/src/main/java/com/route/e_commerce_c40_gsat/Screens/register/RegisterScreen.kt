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
import androidx.navigation.NavHostController
import com.route.e_commerce_c40_gsat.R
import com.route.e_commerce_c40_gsat.Routes

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
        RegisterContent(modifier, navController)
        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Composable
fun RegisterContent(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier.padding(10.dp)) {
        MyText(
            modifier, "  Welcome Back To Route", FontWeight.Bold
        )
        MyText(Modifier, "  Please sign Up with your mail", null)
        TemplateBox(text = "Username\n", placeholder = "enter your name", img = null)
        TemplateBox(
            Modifier
                .padding(0.dp)
                .padding(vertical = 20.dp), "Email Name\n",
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
                .clickable { },
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
fun MyButton(modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        Modifier.fillMaxWidth(),
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) { Text("Login", color = colorResource(R.color.blue), fontSize = 20.sp) }
}
