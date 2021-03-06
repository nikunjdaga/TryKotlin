package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.WeatherListTask
import com.ssyijiu.weatherapp.tools.DelegatesExt
import com.ssyijiu.weatherapp.tools.ToolbarManager
import com.ssyijiu.weatherapp.ui.adapter.WeatherListAdapter
import kotlinx.android.synthetic.main.activity_weather_list.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    var cityId: Long by DelegatesExt.longPreference(SettingsActivity.CITY_ID, SettingsActivity.DEFAULT_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        initToolbar()
        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        requestWeatherList(cityId)
    }

    private fun requestWeatherList(cityId: Long) {
        doAsync {
            val result = WeatherListTask(cityId).execute()
            uiThread {
                result?.let {
                    val adapter = WeatherListAdapter(result)
                    rvWeather.adapter = adapter
                    adapter.setOnItemClickListener {
                        DetailActivity.start(this@MainActivity, cityId, it.date)

                    }
                    toolbarTitle = "${result.city} (${result.country})"
                }


            }
        }
    }

}

