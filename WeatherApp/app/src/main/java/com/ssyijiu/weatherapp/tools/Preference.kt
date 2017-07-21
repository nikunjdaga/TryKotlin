@file:Suppress("UNCHECKED_CAST")

package com.ssyijiu.weatherapp.tools

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.ssyijiu.weatherapp.App
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by ssyijiu on 2017/7/16.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */
class Preference<T>(val key: String, val default: T) : ReadWriteProperty<Any?, T> {

    val prefs: SharedPreferences by lazy {
        App.instance.getSharedPreferences("default", Context.MODE_PRIVATE)
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return prefs.findValue(key, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        return prefs.putValue(key,value)
    }

    @SuppressLint("CommitPrefEdits")
    private fun  <T> SharedPreferences.putValue(key: String, value: T) =
        with(this.edit()) {
            when(value) {
                is Int -> putInt(key, value)
                is Long -> putLong(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                is Float -> putFloat(key, value)
                else -> throw IllegalArgumentException("This type can't be saved into Preferences")
            }
            apply()
        }

    private fun <T> SharedPreferences.findValue(key: String, default: T): T {
        val res: Any = when (default) {
            is Int -> this.getInt(key, default)
            is Long -> this.getLong(key, default)
            is Boolean -> this.getBoolean(key, default)
            is String -> this.getString(key, default)
            is Float -> this.getFloat(key, default)
            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
        }

        return res as T
    }
}




