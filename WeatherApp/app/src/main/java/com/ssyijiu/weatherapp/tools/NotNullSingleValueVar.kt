package com.ssyijiu.weatherapp.tools

import com.ssyijiu.library.MLog
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by ssyijiu on 2017/6/4.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {


    // 默认为 null
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

        // value 为 null 抛出异常
        return value ?: throw IllegalStateException("${property.name} " +
            "not initialized")
    }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {

        MLog.i("thisRef:$thisRef")
        MLog.i("property:$property")
        MLog.i("value:$value")

        // 只有 value 是 null 的时候，才能 setValue
        // setValue 只能正确执行一次
        this.value = if (this.value == null) value
        else throw IllegalStateException("${property.name} already initialized")
    }

}
