package com.route.e_commerce_c40_gsat

object Routes {
    const val LOGIN_SCREEN = "login"
    const val HOME_SCREEN = "home"
    const val REGISTER_SCREEN = "register"
    const val CATEGORIES_SCREEN = "categories"
    const val WISHLIST_SCREEN = "wishlist"
    const val ACCOUNT_SCREEN = "account"
    const val SPLASH_SCREEN = "splash"
}

sealed interface Destination {
    data object Login : Destination
    data object Register : Destination
    data object Home : Destination
}

sealed class BottomAppBarTabs(val icon: Int, val route: String) {

    data object Home : BottomAppBarTabs(R.drawable.ic_home, Routes.HOME_SCREEN)
    data object Categories : BottomAppBarTabs(R.drawable.ic_category, Routes.CATEGORIES_SCREEN)
    data object Wishlist :
        BottomAppBarTabs(R.drawable.ic_wishlist, Routes.WISHLIST_SCREEN)

    data object Account : BottomAppBarTabs(R.drawable.ic_account, Routes.ACCOUNT_SCREEN)
}