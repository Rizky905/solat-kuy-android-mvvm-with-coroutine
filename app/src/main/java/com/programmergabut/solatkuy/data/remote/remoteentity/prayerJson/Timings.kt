package com.programmergabut.solatkuy.data.remote.remoteentity.prayerJson


import com.google.gson.annotations.SerializedName
import javax.inject.Named

data class Timings(
    @SerializedName("Asr")
    @Named("asr")
    var asr: String,

    @SerializedName("Dhuhr")
    @Named("dhuhr")
    var dhuhr: String,

    @SerializedName("Fajr")
    @Named("fajr")
    var fajr: String,

    @SerializedName("Imsak")
    @Named("imsak")
    val imsak: String,

    @SerializedName("Isha")
    @Named("isha")
    var isha: String,

    @SerializedName("Maghrib")
    @Named("maghrib")
    var maghrib: String,

    @SerializedName("Midnight")
    @Named("midnight")
    val midnight: String,

    @SerializedName("Sunrise")
    @Named("sunrise")
    val sunrise: String,

    @SerializedName("Sunset")
    @Named("sunset")
    val sunset: String
)