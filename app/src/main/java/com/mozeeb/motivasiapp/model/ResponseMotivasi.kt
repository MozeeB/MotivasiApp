package com.mozeeb.motivasiapp.model

import com.google.gson.annotations.SerializedName

data class ResponseMotivasi(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("tumbuhan")
	val tumbuhan: List<TumbuhanItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)