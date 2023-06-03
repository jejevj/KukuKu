package com.capstoneproject.kukuku.camera

import android.graphics.Bitmap
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.capstoneproject.kukuku.R

@Composable
fun PickImageFromCamera() {

    var bitmap  by remember{ mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()){
        bitmap = it
    }
    FloatingActionButton(
        onClick = {
            launcher.launch()
        }, backgroundColor = colorResource(id = R.color.fab)
    ) {

        Icon(painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24), contentDescription = "Camera", tint = Color.White)
    }
    Log.i("kilo", bitmap?.asImageBitmap().toString())

}