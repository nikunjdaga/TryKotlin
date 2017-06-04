package com.ssyijiu.weatherapp

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ssyijiu.weatherapp.domain.RequestForecastCommand
import com.ssyijiu.weatherapp.recycleradapter.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvForecastList.layoutManager = LinearLayoutManager(this)
        rvForecastList.setHasFixedSize(true)

        doAsync {
            val result = RequestForecastCommand("94043").execute()

            uiThread {
                rvForecastList.adapter = ForecastListAdapter(result) {
                    toast(it.date)
                }
            }
        }
    }
}

