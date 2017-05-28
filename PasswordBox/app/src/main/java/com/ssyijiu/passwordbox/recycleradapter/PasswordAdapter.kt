package com.ssyijiu.passwordbox.recycleradapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.ssyijiu.passwordbox.R
import com.ssyijiu.passwordbox.bean.PasswordInfo

/**
 * Created by ssyijiu on 2017/5/24.
 * GitHub: ssyijiu
 * E-mail: lxmyijiu@163.com
 */
class PasswordAdapter(var list: ArrayList<PasswordInfo>) : RecyclerView.Adapter<PasswordAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindData(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_password, parent, false))
    }

    override fun getItemCount() = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView: TextView = itemView.findViewById(R.id.textView) as TextView
        init {
            itemView.setOnClickListener(View.OnClickListener {

            })
        }

        fun bindData(info: PasswordInfo) {
            textView.text = info.name
        }
    }
}