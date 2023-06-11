package com.capstoneproject.kukuku.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capstoneproject.kukuku.AnimationSplashScreen
import com.capstoneproject.kukuku.KukuApp
import com.capstoneproject.kukuku.ui.screen.profile.ProfileScreen
import com.capstoneproject.kukuku.ui.screen.result.ResultScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            AnimationSplashScreen(navController)
        }
        composable(route = Screen.Home.route){
            KukuApp(navController = navController)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(onBackClick = {})
        }
        composable(route = Screen.Result.route){
            ResultScreen(onBackClick = {navController.navigateUp()},"",navController)
        }
    }
}
@Composable
fun SetupNavGraph2(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Splash.route){
            AnimationSplashScreen(navController)
        }
        composable(route = Screen.Home.route){
            KukuApp(navController = navController)
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(onBackClick = {})
        }
        composable(route = Screen.Result.route){
            ResultScreen(onBackClick = {navController.navigateUp()},"", navController)
        }
    }
}
