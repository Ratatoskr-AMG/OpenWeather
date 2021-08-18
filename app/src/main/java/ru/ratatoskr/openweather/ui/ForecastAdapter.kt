package ru.ratatoskr.openweather.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ru.ratatoskr.openweather.R
import ru.ratatoskr.openweather.service.Utils
import ru.ratatoskr.openweather.service.model.Daily
import ru.ratatoskr.openweather.service.model.Forecast

class ForecastAdapter(context: Context, resource: Int, values: List<Daily>?) :
    ArrayAdapter<Forecast?>(context, resource) {

    private val values: List<Daily>? = values
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return values!!.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val daily: Daily? = values!![position]
        var holder: ForecastHolder
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false)
            holder = ForecastHolder()
            holder.date = view!!.findViewById<View>(R.id.date) as TextView
            holder.sunrise = view!!.findViewById<View>(R.id.sunrise) as TextView
            holder.sunset = view!!.findViewById<View>(R.id.sunset) as TextView
            holder.temp = view!!.findViewById<View>(R.id.temp) as TextView
            holder.feels_like = view!!.findViewById<View>(R.id.feels_like) as TextView
            view.setTag(holder)
        }
        holder = view!!.tag as ForecastHolder
        holder.date?.setText(Utils.getDateTime(daily?.dt.toString(), "dd/MM"))
        holder.sunrise?.setText(Utils.getDateTime(daily?.sunrise.toString(), "HH:mm"))
        holder.sunset?.setText(Utils.getDateTime(daily?.sunset.toString(), "HH:mm"))
        holder.temp?.setText(daily?.temp?.night.toString())
        holder.feels_like?.setText(daily?.feelsLike?.night.toString())
        return view
    }

}