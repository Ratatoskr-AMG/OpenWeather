package ru.ratatoskr.openweather.service

import android.util.Log
import ru.ratatoskr.openweather.service.model.Daily
import java.lang.Math.abs
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
                var curr_diff = abs(value.temp!!.night!!.toDouble() - value.feelsLike!!.night!!.toDouble())
                if(diff==null || curr_diff < diff){
                    day=value
                    day!!.setDiff(Math.round(curr_diff * 1000.0) / 1000.0);
                    diff=curr_diff
                }
            }
            return day
        }

        fun longestDay(daily : List<Daily>?): Daily? {
            var day : Daily? = null
            var diff : Double? = null
            for (value in daily!!) {
                var curr_diff = value?.sunset!!.toDouble() - value?.sunrise!!.toDouble()
                if(diff==null || curr_diff > diff){
                    day=value
                    day!!.setSunshine(getDateTime(curr_diff.toInt().toString(), "HH:mm"))
                    diff=curr_diff.toDouble()
                }
            }
            return day;
        }
    }
}