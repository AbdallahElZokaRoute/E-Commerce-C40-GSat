package com.route.e_commerce_c40_gsat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.route.e_commerce_c40_gsat.Screens.HomeScreen
import com.route.e_commerce_c40_gsat.model.Categroies
import com.route.e_commerce_c40_gsat.ui.theme.ECommerceGSatTheme

class MainActivity : ComponentActivity() {


    private var categroiesList1 = listOf(
        Categroies("Women's Fashion", R.drawable.women_s_fashion),
        Categroies("men's Fshion", R.drawable.men_s_fashion),
        Categroies("Laptops& Electronics ", R.drawable.laptiop_s_electronics),
        Categroies("Baby\n Toys", R.drawable.baby_toys),
        Categroies("Beauty", R.drawable.beauty),
        Categroies("HeadPhones", R.drawable.headphones),
        Categroies("SkinCare", R.drawable.skincare),
        Categroies("Cameras", R.drawable.cameras)
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECommerceGSatTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(categroiesList1)

                }
            }
        }
    }
}