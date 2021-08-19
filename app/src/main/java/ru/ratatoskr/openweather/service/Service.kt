package ru.ratatoskr.openweather.service

import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ratatoskr.openweather.ui.ForecastAdapter
import ru.ratatoskr.openweather.R
import ru.ratatoskr.openweather.service.model.Forecast

class Service (context : AppCompatActivity, appid: String) : retrofit2.Callback<Forecast?>  {

    private var appid=appid
    private var loading = false
    private var context = context
    private var adapter: ForecastAdapter? = null
    private var list: ListView? = context.findViewById(R.id.list)
    private var longestDayTV: TextView? = context.findViewById(R.id.longestDay)
    private var closestNightTV: TextView? = context.findViewById(R.id.closestNight)
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val connector: Connector = retrofit.create(Connector::class.java)

    fun load() {
        if(!loading){
            loading = true
            val call: Call<Forecast?>? = connector.search(appid)
            call!!.enqueue(this)
        }
    }

    override fun onResponse(call: Call<Forecast?>, response: Response<Forecast?>) {
        adapter = ForecastAdapter(context, R.layout.item, response.body()!!.daily)
        list!!.setAdapter(adapter)
        var closestNight = Utils.closestNight(response.body()!!.daily)
        var longestDay = Utils.longestDay(response.body()!!.daily)
        closestNightTV!!.setText("Most accurate night prognosis (difference is "+closestNight!!.diff.toString()+"°) at "+Utils.getDateTime(closestNight!!.dt!!.toString(), "dd/MM"))
        longestDayTV!!.setText("Longest day (during "+longestDay!!.sunshine.toString()+") at "+Utils.getDateTime(longestDay!!.dt!!.toString(), "dd/MM"))
        loading = false
    }

    override fun onFailure(call: Call<Forecast?>, t: Throwable) {
        loading = false
    }

    fun onDestroy() {
        loading = false
    }
}