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

    protected abstract val mLayoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (this is PasswordListActivity) {
            setTheme(R.style.AppTheme)
        }

        val rootView = View.inflate(this, mLayoutResId, null)
        setContentView(rootView)
        mContext = this

        intent?.let {
            parseIntent(intent)
        }

        initViewAndData(rootView, savedInstanceState)
    }


    open protected fun parseIntent(intent: Intent) {}

    open protected fun initViewAndData(rootView: View, savedInstanceState: Bundle?) {}

}
