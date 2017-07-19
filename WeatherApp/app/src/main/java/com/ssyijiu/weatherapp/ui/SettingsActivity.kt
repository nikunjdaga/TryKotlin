package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.tools.DelegatesExt
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * Created by ssyijiu on 2017/7/16.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */
class SettingsActivity : AppCompatActivity() {

    var cityId :Long by DelegatesExt.longPreference(CITY_ID, DEFAULT_ID)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_settings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        etCityId.setText(cityId.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed(); true
            }
            else -> false
        }


    companion object {
        val CITY_ID = "zipCode"
        val DEFAULT_ID = 94043L
    }

    override fun onBackPressed() {
        super.onBackPressed()
        cityId = etCityId.text.toString().toLong()
    }

}