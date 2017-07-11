package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.WeatherListTask
import com.ssyijiu.weatherapp.ui.adapter.WeatherListAdapter
import kotlinx.android.synthetic.main.activity_weather_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class WeatherListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)

        doAsync {
            val result = WeatherListTask(id).execute()
            uiThread {
                val adapter = WeatherListAdapter(result)
                rvWeather.adapter = adapter
                adapter.setOnItemClickListener {
                    WeatherDetailActivity.start(this@WeatherListActivity,
                        id, it.date, it.description)
                }
            }
        }
    }

    companion object {
        val id = 94043L
    }

}

