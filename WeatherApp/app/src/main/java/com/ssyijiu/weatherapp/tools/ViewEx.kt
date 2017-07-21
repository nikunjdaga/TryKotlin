package com.ssyijiu.weatherapp.tools

import android.content.Context
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Created by ssyijiu on 2017/6/3.
 * GitHub : ssyijiu
 * Email  : lxmyijiu@163.com
 */


/**
 * 返回 view 的 context
 */
val View.ctx:Context
    get() = context

fun Context.color(res: Int): Int
    = ContextCompat.getColor(this, res)

fun View.showSoftInput() {
    Handler().post {
        val imm = this.ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
    }
}
