package com.ssyijiu.passwordbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ssyijiu.library.MLog
import com.ssyijiu.passwordbox.bean.PasswordInfo
import com.ssyijiu.passwordbox.recycleradapter.PasswordAdapter

class PasswordListActivity : AppCompatActivity() {
    lateinit var mRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_list)
        mRecycler = findViewById(R.id.recycler) as RecyclerView
        mRecycler.layoutManager = LinearLayoutManager(this)
        mRecycler.adapter = PasswordAdapter(getData())

        MLog.i(mRecycler)

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
