package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.WeatherTask
import kotlinx.android.synthetic.main.activity_weather_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class WeatherListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)



        doAsync {
            val result = WeatherTask(94043).execute()
            uiThread {
                val adapter = WeatherListAdapter(result)
                rvWeather.adapter = adapter
                adapter.setOnItemClickListener {
                    toast(it.date)
                }
            }
        }

    }

}

