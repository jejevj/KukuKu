package com.capstoneproject.kukuku.model

import com.google.gson.annotations.SerializedName

data class ArtikelResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)

data class DataItem(

	@field:SerializedName("artikel_id")
	val artikelId: Int? = null,

	@field:SerializedName("storage_url")
	val storageUrl: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("isi")
	val isi: String? = null
)
