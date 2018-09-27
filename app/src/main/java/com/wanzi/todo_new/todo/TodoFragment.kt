package com.wanzi.todo_new.todo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wanzi.todo_new.main.MainFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 *  Author : Created by WZ on 2018-09-26 11:46
 *  E-Mail : 1253427499@qq.com
 */
class TodoFragment : MainFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = ArrayList<String>()
        for (i in 0 until 10) {
            data.add("No.$i")
        }

        rv.run {
            layoutManager = LinearLayoutManager(activity)
            this.adapter = TodoAdapter(data)
        }
    }
}