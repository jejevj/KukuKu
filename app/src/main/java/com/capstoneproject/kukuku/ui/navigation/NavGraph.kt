package com.capstoneproject.kukuku.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capstoneproject.kukuku.AnimationSplashScreen
import com.capstoneproject.kukuku.DessertApp
import com.capstoneproject.kukuku.ui.screen.profile.ProfileScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            AnimationSplashScreen(navController)
        }
        composable(route = Screen.Home.route){
            DessertApp()
        }
        composable(route = Screen.Profile.route){

        }
    }
}