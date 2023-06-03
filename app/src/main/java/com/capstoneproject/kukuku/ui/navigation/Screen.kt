package com.capstoneproject.kukuku.ui.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home: Screen("home")
    object Profile: Screen("profile")
    object Result: Screen("result")
    object Detail: Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}