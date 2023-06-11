package com.capstoneproject.kukuku.ui.screen.result

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.capstoneproject.kukuku.R
import com.capstoneproject.kukuku.network.ApiConfig
import com.capstoneproject.kukuku.network.FileUploadResponse
import com.capstoneproject.kukuku.ui.navigation.Screen
import com.capstoneproject.kukuku.utils.uriToFile
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

@Composable
fun ResultScreen(
    onBackClick:() -> Unit,
    path_url: String,
    navController:NavHostController
) {
    val upload = remember{
        mutableStateOf(FileUploadResponse(
            accuracy = "",
            data = null,
            result = "",
            prediction = ""
        ))
    }
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
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .padding(start = 20.dp, end = 5.dp, top = 20.dp, bottom = 20.dp),
            ) {
                AsyncImage(
                    model = path_url,
                    contentDescription = "Result Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxSize()
                )
            }

            GetDetail(path_url = path_url,upload)

            Text(
                text = upload.value.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 20.dp, end=20.dp)
            )
        }
    }
}

@Composable
fun GetDetail(
    path_url: String,
    fileUploadState: MutableState<FileUploadResponse>
){
    var getFile: File?
    val context = LocalContext.current
    val selectedImg = path_url.toUri()
    selectedImg.let { uri ->
        val myFile = uriToFile(uri,context)
        getFile = myFile
    }
        val file = getFile as File
        val requestImageFile = file.asRequestBody("image/jpeg".toMediaType())
        val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
            "file",
            file.name,
            requestImageFile
        )
        val apiService = ApiConfig().getApiService()
        val uploadImageRequest = apiService.uploadImage(imageMultipart)
        uploadImageRequest.enqueue(object : Callback<FileUploadResponse> {
            override fun onResponse(
                call: Call<FileUploadResponse>,
                response: Response<FileUploadResponse>
            ) {
                fileUploadState.value = response.body()!!

                Log.d("COBA",fileUploadState.component1().toString())
                if (response.isSuccessful) {

                    val responseBody = response.body()
                    if (responseBody != null) {
                        Log.d("OI",response.body().toString())
                    }
                } else {
//                        Toast.makeText(this@CameraActivity, response.message(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<FileUploadResponse>, t: Throwable) {
//                    Toast.makeText(this@CameraActivity, t.message, Toast.LENGTH_SHORT).show()
            }


        }
        )

            Text(
                text = fileUploadState.component1().toString(),
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.primary_text)
                ),
                modifier = Modifier.padding(start = 20.dp, end=20.dp)
            )

    }



