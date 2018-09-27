package com.wanzi.todo_new.main

import com.wanzi.todo_new.di.ActivityScoped
import javax.inject.Inject

/**
 *  Author : Created by WZ on 2018-09-26 14:52
 *  E-Mail : 1253427499@qq.com
 */
@ActivityScoped
class MainPresenter @Inject constructor() : MainContract.Presenter {

    private var mMainView: MainContract.View? = null

    override fun toLogin() {
        mMainView?.showLoginUi()
    }

    override fun signOut() {
        mMainView?.setSignOut()
    }

    override fun takeView(view: MainContract.View) {
        this.mMainView = view
    }

    override fun dropView() {
        mMainView = null
    }
}