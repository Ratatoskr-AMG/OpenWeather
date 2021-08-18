package ru.ratatoskr.openweather.service

import android.util.Log
import ru.ratatoskr.openweather.service.model.Daily
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        fun getDateTime(s: String, pattern: String): String? {
            val sdf = SimpleDateFormat(pattern)
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        }

        fun closestNight(daily : List<Daily>?): Daily? {
            var day : Daily? = null
            var diff : Double? = null
            for (value in daily!!) {
                var curr_diff = value.temp!!.night!!.minus(value.feelsLike!!.night!!.toLong())
                if(diff==null || curr_diff < diff){
                    day=value
                    diff=curr_diff
                }
            }
            return day
        }

        fun longestDay(daily : List<Daily>?): Daily? {
            var day : Daily? = null
            var diff : Double? = null
            for (value in daily!!) {
                var curr_diff = value?.sunset!!.minus(value?.sunrise!!)
                if(diff==null || curr_diff > diff){
                    day=value
                    diff=curr_diff.toDouble()
                }
            }
            return day;
        }
    }
}