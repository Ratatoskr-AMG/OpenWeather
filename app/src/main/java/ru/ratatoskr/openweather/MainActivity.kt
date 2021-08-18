package ru.ratatoskr.openweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ratatoskr.openweather.service.Service

class MainActivity : AppCompatActivity() {
    private lateinit var  service : Service
    var appid = "7d28b1e16196e0fccdab2cf4bf4a26d2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service = Service(this,appid)
        service!!.load();
    }
    override fun onDestroy() {
        super.onDestroy()
        service!!.onDestroy()
    }
}