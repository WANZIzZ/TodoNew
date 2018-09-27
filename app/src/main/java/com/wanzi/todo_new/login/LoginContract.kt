package com.wanzi.todo_new.login

import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.wanzi.todo_new.base.BasePresenter
import com.wanzi.todo_new.base.BaseView

/**
 *  Author : Created by WZ on 2018-09-27 10:10
 *  E-Mail : 1253427499@qq.com
 */
interface LoginContract {

    interface View : BaseView<Presenter> {

        fun checkContent(): Boolean

        fun showRegisterUi()

        fun getLifecycleProvider(): AndroidLifecycleScopeProvider

        fun loginSuccess()

        fun loginFail(e: Throwable)
    }

    interface Presenter : BasePresenter<View> {

        fun login(username: String, password: String)

        fun register()
    }
}