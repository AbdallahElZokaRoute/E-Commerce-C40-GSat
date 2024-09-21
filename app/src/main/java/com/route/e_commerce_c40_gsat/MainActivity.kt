package com.route.e_commerce_c40_gsat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce_c40_gsat.Screens.home.HomeScreen
import com.route.e_commerce_c40_gsat.Screens.login.LoginScreenContent
import com.route.e_commerce_c40_gsat.Screens.register.RegisterScreenContent
import com.route.e_commerce_c40_gsat.ui.theme.ECommerceGSatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceGSatTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
                        composable(Routes.LOGIN_SCREEN) {
                            LoginScreenContent(Modifier.padding(innerPadding), navController)
                        }
                        composable(Routes.HOME_SCREEN) {
                            HomeScreen(categoriesList = CategoriesUtils.categoriesList1)
                        }
                        composable(Routes.REGISTER_SCREEN) {
                            RegisterScreenContent(navController = navController)
                        }
                    }

                }
            }
        }
    }
}







