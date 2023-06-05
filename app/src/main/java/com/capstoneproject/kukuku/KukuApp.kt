package com.capstoneproject.kukuku

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.camera.PickImageFromCamera
import com.capstoneproject.kukuku.ui.navigation.Screen
import com.capstoneproject.kukuku.ui.screen.detail.DetailScreen
import com.capstoneproject.kukuku.ui.screen.home.HomeScreen
import com.capstoneproject.kukuku.ui.screen.profile.ProfileScreen
import com.capstoneproject.kukuku.ui.screen.result.ResultScreen

@Composable
fun KukuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    ){

//    val launcherIntentCamera = registerForActivityResult()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
//                TopBar(navController = navController, modifier = modifier.padding(start = 10.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = "https://i.ibb.co/xYc5bCJ/top.png",
                        contentDescription = "header",
                        contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxWidth()
                    )
                }
            }
        },

        bottomBar = {

            if(currentRoute == Screen.Splash.route){

            }else{ MyBottomBar()}
                    },
        floatingActionButton = {
            if(currentRoute == Screen.Splash.route){

            }else{
                PickImageFromCamera(navController = navController)
            }
        },

        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = Screen.Splash.route){
            AnimationSplashScreen(navController)
            }
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                })
            }
            composable(route = Screen.Detail.route, arguments = listOf(navArgument("id") { type = NavType.LongType })) {
                val id = it.arguments?.getLong("id") ?: -1L
                DetailScreen(
                    id = id,
                    navigateBack = {
                    navController.navigateUp()
                })
            }
            composable(route = Screen.Profile.route) {
                ProfileScreen(onBackClick = { navController.navigateUp() })
            }
            composable(route = Screen.Result.route) {
                ResultScreen(onBackClick = { navController.navigateUp() },"" ,navController)
            }
        }
    }
//    MyUI()
}


@Composable
fun MyBottomBar() {
    // items list
    val bottomMenuItemsList = prepareBottomMenu()

    var selectedItem by remember {
        mutableStateOf("home")
    }

    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = colorResource(id =R.color.primary_text)
    ) {
        bottomMenuItemsList.forEachIndexed { index, menuItem ->
            if (index == 1) {
                // add an empty space for FAB
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    label = {},
                    icon = {},
                    enabled = false
                )
            }

            BottomNavigationItem(
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                selected = (selectedItem == menuItem.label),
                onClick = {
                    selectedItem = menuItem.label
//                    Toast.makeText(
//                        contextForToast,
//                        menuItem.label, Toast.LENGTH_SHORT
//                    ).show()
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                enabled = true
            )
        }
    }
}

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

    // add menu items
    bottomMenuItemsList.add(BottomMenuItem(label = "home", icon = Icons.Filled.Home))
    bottomMenuItemsList.add(BottomMenuItem(label = "profile", icon = Icons.Filled.Info))

    return bottomMenuItemsList
}



data class BottomMenuItem(val label: String, val icon: ImageVector)

