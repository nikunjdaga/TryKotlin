package com.ssyijiu.passwordbox.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ssyijiu.passwordbox.PasswordListActivity
import com.ssyijiu.passwordbox.R

/**
 * Created by ssyijiu on 2017/4/5.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

abstract class BaseActivity : AppCompatActivity() {

    lateinit protected var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(this is PasswordListActivity) {
            setTheme(R.style.AppTheme)
        }

        val rootView = View.inflate(this, layoutResId, null)
        setContentView(rootView)
        mContext = this

        if (intent != null) {
            parseIntent(intent)
        }
        initViewAndData(rootView, savedInstanceState)
    }


    open protected fun parseIntent(intent: Intent) {}

    @get:LayoutRes
    protected abstract val layoutResId: Int

    open protected fun initViewAndData(rootView: View, savedInstanceState: Bundle?) {}

}
