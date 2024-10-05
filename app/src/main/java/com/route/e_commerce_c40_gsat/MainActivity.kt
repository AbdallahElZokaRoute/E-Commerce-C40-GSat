package com.route.e_commerce_c40_gsat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.route.e_commerce_c40_gsat.Screens.home.HomeScreen
import com.route.e_commerce_c40_gsat.Screens.login.LoginScreenContent
import com.route.e_commerce_c40_gsat.Screens.register.RegisterScreenContent
import com.route.e_commerce_c40_gsat.Screens.splash.SplashScreen
import com.route.e_commerce_c40_gsat.ui.theme.ECommerceGSatTheme
import com.route.e_commerce_c40_gsat.utils.ECommerceBottomAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceGSatTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val bottomAppbarTabs = listOf(
                            BottomAppBarTabs.Home,
                            BottomAppBarTabs.Categories,
                            BottomAppBarTabs.Wishlist,
                            BottomAppBarTabs.Account
                        )
                        val destination =
                            navController.currentBackStackEntryAsState()?.value?.destination?.route
                                ?: ""
                        Log.e("TAG", "onCreate: $destination")
                        if (destination in bottomAppbarTabs.map {
                                it.route
                            })
                            ECommerceBottomAppBar(
                                tabsList = bottomAppbarTabs
                            ) { position ->
                                when (position) {
                                    0 -> {
                                        navController.navigate(Routes.HOME_SCREEN)
                                    }

                                    1 -> {
                                        navController.navigate(Routes.CATEGORIES_SCREEN)
                                    }

                                    2 -> {
                                        navController.navigate(Routes.WISHLIST_SCREEN)
                                    }

                                    3 -> {
                                        navController.navigate(Routes.ACCOUNT_SCREEN)
                                    }

                                    else -> {}

                                }
                            }
                    }
                ) { innerPadding ->

                    NavHost(
                        modifier = Modifier.padding(
                            bottom = innerPadding.calculateBottomPadding()
                        ),
                        navController = navController,
                        startDestination = Routes.SPLASH_SCREEN
                    ) {
                        composable(Routes.LOGIN_SCREEN) {
                            LoginScreenContent(Modifier.padding(innerPadding), navController)
                        }
                        composable(Routes.HOME_SCREEN) {
                            HomeScreen(navController = navController)
                        }
                        composable(Routes.REGISTER_SCREEN) {
                            RegisterScreenContent(navController = navController)
                        }
                        composable(Routes.SPLASH_SCREEN) {
                            SplashScreen(navController)
                        }

                        composable(Routes.WISHLIST_SCREEN) {

                        }
                        composable(Routes.ACCOUNT_SCREEN) {

                        }
                        composable(Routes.CATEGORIES_SCREEN) {

                        }
                    }

                }
            }
        }
    }
}







