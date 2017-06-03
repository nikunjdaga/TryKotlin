package com.ssyijiu.weatherapp.extensions

import android.content.Context
import android.view.View

/**
 * Created by ssyijiu on 2017/6/3.
 * Github : ssyijiu
 * Email  : lxmyijiu@163.com
 */


// 给 View 添加一个扩展属性
// ctx 返回 context
val View.ctx:Context
    get() = context
