package ru.ratatoskr.openweather.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Forecast {


    @SerializedName("lat")
    @Expose
    var lat: Double? = null

    @SerializedName("lon")
    @Expose
    var lon: Double? = null

    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    @SerializedName("timezone_offset")
    @Expose
    var timezoneOffset: Int? = null

    @SerializedName("current")
    @Expose
    var current: Current? = null

    @SerializedName("minutely")
    @Expose
    var minutely: List<Minutely>? = null

    @SerializedName("hourly")
    @Expose
    var hourly: List<Hourly>? = null

    @SerializedName("daily")
    @Expose
    var daily: List<Daily>? = null

    @SerializedName("alerts")
    @Expose
    var alerts: List<Alert>? = null


}