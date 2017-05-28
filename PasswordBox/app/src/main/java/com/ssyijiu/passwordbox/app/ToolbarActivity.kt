package com.ssyijiu.passwordbox.app

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.ssyijiu.passwordbox.R


/**
 * Created by ssyijiu on 2017/5/25.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */

abstract class ToolbarActivity : BaseActivity() {

    lateinit private var mToolbar: Toolbar
    lateinit private var mToolbarTitle: TextView

    override val mLayoutResId = R.layout.layout_toolbar

    protected abstract val mTitle: String
    protected abstract val mContentViewResId: Int

    override fun initViewAndData(rootView: View, savedInstanceState: Bundle?) {
        super.initViewAndData(rootView, savedInstanceState)

        mToolbar = findViewById(R.id.toolbar) as Toolbar
        mToolbarTitle = findViewById(R.id.title) as TextView

        setSupportActionBar(mToolbar)

        supportActionBar?.let {
            supportActionBar!!.setDisplayShowTitleEnabled(true)   // 显示默认 title
            supportActionBar!!.setDisplayShowHomeEnabled(false)   // 去掉默认 icon
            title = mTitle
        }

        val rootLayout = rootView as LinearLayout
        val contentView = View.inflate(mContext, mContentViewResId, rootLayout)

        setToolbar()
        initContentView(contentView)
    }



    private fun setToolbar() {
        when (toolbarMode()) {
            ToolbarMode.MODE_BACK -> mToolbar.setNavigationIcon(R.drawable.ic_arrow_left_white)
        }

        mToolbar.setNavigationOnClickListener {
            when (toolbarMode()) {
                ToolbarMode.MODE_BACK -> mContext.onBackPressed()
            }
        }
    }

    open protected fun toolbarMode(): Int {
        return ToolbarMode.MODE_BACK
    }

    protected abstract fun initContentView(contentView: View)
}