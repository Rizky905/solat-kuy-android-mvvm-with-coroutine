package com.programmergabut.solatkuy.data.remote.remoteentity.quransurahJson


import com.google.gson.annotations.SerializedName
import java.util.*

data class Ayah(
    @SerializedName("hizbQuarter")
    val hizbQuarter: Int,
    @SerializedName("juz")
    val juz: Int,
    @SerializedName("manzil")
    val manzil: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("numberInSurah")
    val numberInSurah: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("ruku")
    val ruku: Int,
    @SerializedName("sajda")
    val sajda: Boolean,
    @SerializedName("text")
    val text: String
)