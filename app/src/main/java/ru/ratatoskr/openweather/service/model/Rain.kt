package ru.ratatoskr.openweather.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    @Expose
    var h : Double? = null

}