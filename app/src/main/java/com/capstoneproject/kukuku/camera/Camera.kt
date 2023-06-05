package com.capstoneproject.kukuku.camera

import android.content.Intent
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.capstoneproject.kukuku.CameraActivity
import com.capstoneproject.kukuku.R

@Composable
    fun PickImageFromCamera(navController: NavHostController = rememberNavController()) {
        val mContext = LocalContext.current
        FloatingActionButton(
            onClick = {
                mContext.startActivity(Intent(mContext, CameraActivity()::class.java))

            }, backgroundColor = colorResource(
                id =
                R.color.fab
            )
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24),
                contentDescription = "CameraActivity",
                tint = Color.White
            )
        }

//    Log.i("kilo", bitmap?.asImageBitmap().toString())
    }
