package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.ssyijiu.weatherapp.App
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.R.id.rvWeather
import com.ssyijiu.weatherapp.net.WeatherListTask
import com.ssyijiu.weatherapp.tools.ToolbarManager
import com.ssyijiu.weatherapp.tools.ctx
import com.ssyijiu.weatherapp.ui.adapter.WeatherListAdapter
import kotlinx.android.synthetic.main.activity_weather_list.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.*

class WeatherListActivity : AppCompatActivity(), ToolbarManager{

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)

        initToolbar()
        enableHomeAsUp {
            toast("Home")
        }
        attachToScroll(rvWeather)

        doAsync {
            val result = WeatherListTask(id).execute()
            uiThread {
                val adapter = WeatherListAdapter(result)
                rvWeather.adapter = adapter
                adapter.setOnItemClickListener {
                    WeatherDetailActivity.start(this@WeatherListActivity, id, it.date)

                }
                toolbarTitle = "${result.city} (${result.country})"
            }
        }
    }

    companion object {
        val id = 94043L
    }

}

