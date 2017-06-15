package com.ssyijiu.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ssyijiu.weatherapp.net.WeatherTask
import com.ssyijiu.weatherapp.recycleradapter.WeatherAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)

        doAsync {
            val result = WeatherTask("94043").execute()
            uiThread {
                rvWeather.adapter = WeatherAdapter(result) {
                    toast(it.date)
                }
            }
        }

    }
}

