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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.capstoneproject.kukuku.R
import com.capstoneproject.kukuku.ui.navigation.Screen
import java.io.File
import java.io.FileOutputStream


@Composable
fun PickImageFromCamera(navController:NavHostController) {
    val context = LocalContext.current
    val path = context.getExternalFilesDir(null)!!.absolutePath


    var bitmap  by remember{ mutableStateOf<Bitmap?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()){
        bitmap = it

        val image = bitmap

        val tempFile = File(path , "tempFileName.jpg")
        val fOut = FileOutputStream(tempFile)
        image!!.compress(Bitmap.CompressFormat.JPEG , 100 , fOut)

        Log.i("kilo", image.toString())
        fOut.close()
        navController.navigate(Screen.Result.route)
    }
    FloatingActionButton(
        onClick = {
            launcher.launch()

        }, backgroundColor = colorResource(id =
        R.color.fab)
    ) {

        Icon(painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24), contentDescription = "Camera", tint = Color.White)
    }

    Log.i("kilo", bitmap?.asImageBitmap().toString())
}