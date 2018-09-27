package com.wanzi.todo_new.main

import com.wanzi.todo_new.base.BasePresenter
import com.wanzi.todo_new.base.BaseView

/**
 *  Author : Created by WZ on 2018-09-26 14:40
 *  E-Mail : 1253427499@qq.com
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun showLoginUi()

        fun setSignOut()
    }

    interface Presenter : BasePresenter<View> {

        fun toLogin()

        fun signOut()
    }
}