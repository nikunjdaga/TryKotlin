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
class LongPreference(val name:String, val default:Long): ReadWriteProperty<Any?,Long> {

    val prefs by lazy {
        App.instance.getSharedPreferences("LongPreference", Context.MODE_PRIVATE)
    }


    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}