package ru.ratatoskr.openweather.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Minutely {
    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("precipitation")
    @Expose
    var precipitation: Double? = null
}