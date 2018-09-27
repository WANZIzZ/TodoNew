package com.wanzi.todo_new.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanzi.todo_new.R
import dagger.android.support.DaggerFragment

/**
 *  Author : Created by WZ on 2018-09-26 11:48
 *  E-Mail : 1253427499@qq.com
 */
abstract class MainFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}