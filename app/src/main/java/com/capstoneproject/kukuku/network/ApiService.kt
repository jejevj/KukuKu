package com.capstoneproject.kukuku.network

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
data class FileUploadResponse(

    @field:SerializedName("result")
    val result: String? = null,

    @field:SerializedName("data")
    val data: DataItem? = null,

    @field:SerializedName("prediction")
    val prediction: String? = null,

    @field:SerializedName("accuracy")
    val accuracy: Any? = null
)

data class DataItem(
    @field:SerializedName("resiko")
    val resiko: String? = null,

    @field:SerializedName("nama_penyakit")
    val namaPenyakit: String? = null,

    @field:SerializedName("deskripsi")
    val deskripsi: String? = null,

    @field:SerializedName("gejala")
    val gejala: String? = null,

    @field:SerializedName("tips")
    val tips: String? = null
)



interface ApiService {
    @Multipart
    @POST("/predict")
    fun uploadImage(
        @Part file: MultipartBody.Part,
    ): Call<FileUploadResponse>
}

class ApiConfig {
    fun getApiService(): ApiService {
        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://backend-api-vil4aiqokq-et.a.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}