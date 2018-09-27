package com.wanzi.todo_new.login

import com.uber.autodispose.AutoDispose
import com.wanzi.todo_new.di.ActivityScoped
import com.wanzi.todo_new.retrofit.API
import com.wanzi.todo_new.retrofit.HttpResultFunction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *  Author : Created by WZ on 2018-09-27 10:13
 *  E-Mail : 1253427499@qq.com
 */
@ActivityScoped
class LoginPresenter @Inject constructor() : LoginContract.Presenter {

    @Inject
    lateinit var mApi: API

    private var mLoginView: LoginContract.View? = null

    override fun login(username: String, password: String) {
        if (mLoginView?.checkContent() == true) {
            mApi.login(username, password)
                    .map(HttpResultFunction())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .`as`(AutoDispose.autoDisposable(mLoginView?.getLifecycleProvider()))
                    .subscribe({
                        mLoginView?.loginSuccess()
                    }, {
                        mLoginView?.loginFail(it)
                    })
        }
    }

    override fun register() {
        mLoginView?.showRegisterUi()
    }

    override fun takeView(view: LoginContract.View) {
        this.mLoginView = view
    }

    override fun dropView() {
        mLoginView = null
    }
}