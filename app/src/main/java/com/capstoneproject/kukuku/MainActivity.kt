package com.capstoneproject.kukuku

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.capstoneproject.kukuku.ui.theme.KukukuApplicationTheme
import com.capstoneproject.kukuku.ui.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        isGranted ->
        if (isGranted){
            Log.i("kilo","Permission Granted")
        }else{
            Log.i("kilo","Permission Denied")

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KukukuApplicationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                )
                {
                    requestCameraPermission()
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
//                    Splash(alpha = 1f)
//                    DessertApp()
////                    MyUI()
                }
            }
        }
    }

    private fun requestCameraPermission(){
        when {
            ContextCompat.checkSelfPermission(
                this,Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED->{
                Log.i("kilo","Permission previously granted")
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            )->Log.i("kilo","Show camera permission dialog")

            else -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }
}
