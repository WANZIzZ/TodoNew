package com.wanzi.todo_new.register

import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.wanzi.todo_new.base.BasePresenter
import com.wanzi.todo_new.base.BaseView

/**
 *  Author : Created by WZ on 2018-09-27 15:42
 *  E-Mail : 1253427499@qq.com
 */
interface RegisterContract {

    interface View : BaseView<Presenter> {

        fun checkContent(): Boolean

        fun getLifecycleProvider(): AndroidLifecycleScopeProvider

        fun registerSuccess()

        fun registerFail(e: Throwable)
    }

    interface Presenter : BasePresenter<View> {

        fun register(username: String, password: String, repassword: String)
    }
}