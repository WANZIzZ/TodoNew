package com.wanzi.todo_new.base

/**
 *  Author : Created by WZ on 2018-09-26 10:37
 *  E-Mail : 1253427499@qq.com
 */
interface BasePresenter<T> {

    fun takeView(view: T)

    fun dropView()
}