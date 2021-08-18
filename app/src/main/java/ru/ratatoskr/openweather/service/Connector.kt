package ru.ratatoskr.openweather.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.ratatoskr.openweather.service.model.Forecast

interface Connector {
    @GET("onecall?lat=55.78&lon=37.62&exclude=hourly,minutely,current&units=metric")
    fun search(
        @Query("appid") appid: String?
        ): Call<Forecast?>?
}