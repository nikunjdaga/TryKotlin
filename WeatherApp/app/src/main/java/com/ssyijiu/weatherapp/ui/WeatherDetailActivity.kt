package com.ssyijiu.weatherapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.DebugUtils
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.tools.color
import com.ssyijiu.weatherapp.net.WeatherDetailTask
import com.ssyijiu.weatherapp.net.data.WeatherBean
import com.ssyijiu.weatherapp.tools.ToolbarManager
import kotlinx.android.synthetic.main.activity_weather_detail.*
import org.jetbrains.anko.*

class WeatherDetailActivity : AppCompatActivity(),ToolbarManager {


    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        val cityId = intent.getLongExtra(CITY_ID, 0)
        val cityDate = intent.getStringExtra(CITY_DATA)

        initToolbar()
        enableHomeAsUp {
            onBackPressed()
        }

        toolbarTitle = cityDate

        doAsync {
            val weatherBean = WeatherDetailTask(cityId, cityDate).execute()
            uiThread {
                weatherBean?.let {
                    bindWeather(weatherBean)
                }

            }
        }

    }

    private fun bindWeather(weatherBean: WeatherBean) {
        with(weatherBean) {
            Picasso.with(ctx).load(iconUrl).into(icon)
            weatherDescription.text = description
            maxTemperature.text = "$high"
            minTemperature.text = "$low"
            maxTemperature.setTextColor(color(highColor))
            minTemperature.setTextColor(color(lowColor))

            // bindTemperature(high to maxTemperature, low to minTemperature)
        }
    }


    // 非常好的设计，把数据和控件结合起来
    private fun bindTemperature(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}"
        it.second.setTextColor(
            color(when (it.first) {
                in -50..0 -> android.R.color.holo_blue_dark
                in 0..15 -> android.R.color.holo_green_dark
                else -> android.R.color.holo_red_dark
            }))
    }

    companion object {
        val CITY_ID = "DetailActivity:cityId"
        val CITY_DATA = "DetailActivity:cityDate"

        fun start(context: Context, cityId: Long, cityDate: String) {
            val intent = Intent(context, WeatherDetailActivity::class.java)
            intent.putExtra(CITY_ID, cityId)
            intent.putExtra(CITY_DATA, cityDate)
            context.startActivity(intent)
        }
    }
}
