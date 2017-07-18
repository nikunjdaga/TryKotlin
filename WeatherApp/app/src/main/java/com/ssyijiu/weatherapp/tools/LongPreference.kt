package com.ssyijiu.weatherapp.tools

import android.content.Context
import com.ssyijiu.weatherapp.App
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by ssyijiu on 2017/7/16.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */
class LongPreference(val key: String, val default: Long) : ReadWriteProperty<Any?, Long> {

    val prefs by lazy {
        App.instance.getSharedPreferences("LongPreference", Context.MODE_PRIVATE)
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return prefs.getLong(key, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        return prefs.edit().putLong(key, value).apply()
    }

}