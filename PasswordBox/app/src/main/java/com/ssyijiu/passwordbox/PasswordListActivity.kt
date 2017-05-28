package com.ssyijiu.passwordbox

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ssyijiu.passwordbox.app.ToolbarActivity
import com.ssyijiu.passwordbox.bean.PasswordInfo
import com.ssyijiu.passwordbox.recycleradapter.PasswordAdapter

class PasswordListActivity : ToolbarActivity() {

    lateinit private var mRecycler: RecyclerView

    override val mTitle = "Password"
    override val mContentViewResId = R.layout.activity_password_list

    override fun initContentView(contentView: View) {
        mRecycler = findViewById(R.id.recycler) as RecyclerView
        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.adapter = PasswordAdapter(getData())
    }

    fun getData() = arrayListOf(
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567"),
        PasswordInfo("1234567")
    )
}
