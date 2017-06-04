package com.ssyijiu.weatherapp

import android.app.Application
import com.ssyijiu.weatherapp.extensions.DelegatesExt

/**
 * Created by ssyijiu on 2017/6/4.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}


