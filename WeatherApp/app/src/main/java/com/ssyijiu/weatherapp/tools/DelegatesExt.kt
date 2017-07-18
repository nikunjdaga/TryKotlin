package com.ssyijiu.weatherapp.tools

import kotlin.properties.ReadWriteProperty

/**
 * Created by ssyijiu on 2017/7/18.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class DelegatesExt {

    companion object {
        fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

        fun longPreference(key: String, default: Long) =
            LongPreference(key, default)
    }
}