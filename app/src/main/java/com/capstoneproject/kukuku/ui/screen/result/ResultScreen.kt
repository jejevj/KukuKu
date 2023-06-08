package com.capstoneproject.kukuku.ui.screen.result

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.ui.navigation.Screen

@Composable
fun ResultScreen(
    onBackClick:() -> Unit,
    path_url: String,
    navController:NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(Screen.Home.route)
                    }
            )
            AsyncImage(model = path_url, contentDescription ="Oi" )
        }
    }
}