package com.capstoneproject.kukuku

import android.graphics.Bitmap
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.capstoneproject.kukuku.camera.PickImageFromCamera
import com.capstoneproject.kukuku.ui.navigation.Screen
import com.capstoneproject.kukuku.ui.screen.detail.DetailScreen
import com.capstoneproject.kukuku.ui.screen.home.HomeScreen
import com.capstoneproject.kukuku.ui.screen.profile.ProfileScreen
import com.capstoneproject.kukuku.ui.theme.KukukuApplicationTheme

@Composable
fun KukuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
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
        bottomBar = { MyBottomBar() },
        floatingActionButton = { PickImageFromCamera()
        },

        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
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
        }
    }
//    MyUI()
}


@Composable
fun MyBottomBar() {
    // items list
    val bottomMenuItemsList = prepareBottomMenu()

    val contextForToast = LocalContext.current.applicationContext

    var selectedItem by remember {
        mutableStateOf("Home")
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
                    Toast.makeText(
                        contextForToast,
                        menuItem.label, Toast.LENGTH_SHORT
                    ).show()
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
    bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = Icons.Filled.Home))
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = Icons.Filled.Info))

    return bottomMenuItemsList
}



data class BottomMenuItem(val label: String, val icon: ImageVector)

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hello World", color = Color.Black)
            }
        }
    }
}
@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.drawable.logo))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState.progress }
        )
        if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
            navController.navigate(Screen.Home.route)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DessertAppPreview() {
    KukukuApplicationTheme {
        KukuApp()
//        MyUI()
    }
}
