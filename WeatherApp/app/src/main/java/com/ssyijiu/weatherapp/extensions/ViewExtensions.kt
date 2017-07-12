package com.ssyijiu.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


// 给 View 添加一个扩展属性
// ctx 返回 context
val View.ctx:Context
    get() = context

fun Context.color(res: Int): Int
    = ContextCompat.getColor(this, res)
