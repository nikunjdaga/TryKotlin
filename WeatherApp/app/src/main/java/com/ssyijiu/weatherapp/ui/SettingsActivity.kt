package com.ssyijiu.weatherapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.ssyijiu.weatherapp.R
import com.ssyijiu.weatherapp.tools.DelegatesExt
import com.ssyijiu.weatherapp.tools.ToolbarManager
import com.ssyijiu.weatherapp.tools.showSoftInput
import com.ssyijiu.weatherapp.tools.toLongSafe
import kotlinx.android.synthetic.main.activity_settings.*
import org.jetbrains.anko.find


/**
 * Created by ssyijiu on 2017/7/16.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */
class SettingsActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    var cityId: Long by DelegatesExt.preference(CITY_ID, DEFAULT_ID)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        toolbarTitle = "Input City ID"
        enableHomeAsUp {
            onBackPressed()
        }

        etCityId.setText(cityId.toString())
        etCityId.setSelection(etCityId.text.toString().length)
        etCityId.requestFocus()
    }

    companion object {
        val CITY_ID = "zipCode"
        val DEFAULT_ID = 94043L
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // 保存 cityId 到 sp 中
        cityId = etCityId.text.toString().toLongSafe()
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            currentFocus.showSoftInput()
        }
    }
}




