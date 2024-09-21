package com.route.e_commerce_c40_gsat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Scaffold
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
import com.route.e_commerce_c40_gsat.ui.theme.ECommerceGSatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceGSatTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = colorResource(R.color.blue)) { innerPadding ->
                  Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    MyRouteImage(Modifier)
                    LoginContent(Modifier.padding(innerPadding))
                  }
            }
        }}
    }
}


@Composable
fun LoginContent(modifier: Modifier = Modifier) {
    Column( modifier.padding(10.dp)) {
        MyText(modifier
            ,"  Welcome Back To Route",FontWeight.Bold)
        MyText(Modifier,"  Please sign in with your mail",null)
        TemplateBox(Modifier.padding(0.dp).padding(vertical = 20.dp),"User Name\n",
            "enter your name",null)
        TemplateBox(Modifier.padding(0.dp),"Password\n"
            ,"enter your Password",R.drawable.img)
        MyText( Modifier ,"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tForgot password\n",null)
        MyButton()
        MyText(modifier = Modifier.fillMaxWidth().clickable {  },"\nDon’t have an account? Create Account",null)


    }






}




@Composable
fun TemplateBox(modifier: Modifier = Modifier, text: String, placeholder: String,img:Int?) {
    Column(Modifier.padding(vertical = 15.dp)) {
        val textValue = remember { mutableStateOf("") }
Text(text, color = Color.White, fontSize = 20.sp)
        OutlinedTextField(
            modifier=Modifier.fillMaxWidth(),
            value = textValue.value,
            onValueChange = {   textValue.value = it },

            placeholder = { Text(text = placeholder) },

            shape = OutlinedTextFieldDefaults.shape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White),
            leadingIcon={
                if (img != null) {
                    painterResource(img )
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
fun MyText(modifier: Modifier = Modifier,text:String,weight: FontWeight?) {
    Text(text,color=Color.White, fontWeight = weight, fontSize = 20.sp)
}

@Composable
fun MyButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        Modifier.fillMaxWidth(),
        shape = ButtonDefaults.shape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) { Text("Login" , color = colorResource(R.color.blue), fontSize = 20.sp)}

}




