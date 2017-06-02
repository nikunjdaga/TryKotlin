package com.ssyijiu.passwordbox.app

import android.app.Application

/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

class App : Application() {

    companion object {
        private var app: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}


