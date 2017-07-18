package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.tools.DelegatesExt
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * Created by ssyijiu on 2017/7/16.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */
class SettingsActivity : AppCompatActivity() {

    val zipCode by DelegatesExt.longPreference(ZIP_CODE, DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_settings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed(); true
            }
            else -> false
        }


    companion object {
        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP = 94043L
    }

}