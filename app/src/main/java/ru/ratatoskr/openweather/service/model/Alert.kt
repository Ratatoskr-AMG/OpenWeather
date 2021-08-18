package ru.ratatoskr.openweather.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Alert {
    @SerializedName("sender_name")
    @Expose
    var senderName: String? = null

    @SerializedName("event")
    @Expose
    var event: String? = null

    @SerializedName("start")
    @Expose
    var start: Int? = null

    @SerializedName("end")
    @Expose
    var end: Int? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null
}