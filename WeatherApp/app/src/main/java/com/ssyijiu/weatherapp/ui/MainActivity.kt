package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ssyijiu.library.MLog
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.net.WeatherProvider
import com.ssyijiu.weatherapp.net.WeatherTask
import com.ssyijiu.weatherapp.net.data.WeatherBean
import com.ssyijiu.weatherapp.ui.WeatherAdapter.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_forecast.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWeather.layoutManager = LinearLayoutManager(this)
        rvWeather.setHasFixedSize(true)



        doAsync {
            val result = WeatherTask(94043).execute()
            uiThread {
                rvWeather.adapter = WeatherAdapter(result, object :OnItemClickListener {
                    override fun onItemClick(bean: WeatherBean) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        }

    }

}

