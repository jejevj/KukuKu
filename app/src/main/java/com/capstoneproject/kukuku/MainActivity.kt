package com.capstoneproject.kukuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.capstoneproject.kukuku.ui.theme.KukukuApplicationTheme
import com.capstoneproject.kukuku.ui.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KukukuApplicationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                )
                {

                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
//                    Splash(alpha = 1f)
//                    DessertApp()
////                    MyUI()
                }
            }
        }
    }
}
