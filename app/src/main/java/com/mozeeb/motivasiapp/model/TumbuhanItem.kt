package com.mozeeb.motivasiapp.model

import com.google.gson.annotations.SerializedName

data class TumbuhanItem(

	@field:SerializedName("penulis")
	val penulis: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("motivasi")
	val motivasi: String? = null
)