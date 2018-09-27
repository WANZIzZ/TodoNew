package com.wanzi.todo_new.register

import com.uber.autodispose.AutoDispose
import com.wanzi.todo_new.retrofit.API
import com.wanzi.todo_new.retrofit.HttpResultFunction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 *  Author : Created by WZ on 2018-09-27 15:46
 *  E-Mail : 1253427499@qq.com
 */
class RegisterPresenter @Inject constructor() : RegisterContract.Presenter {

    private var mRegisterView: RegisterContract.View? = null

    @Inject
     lateinit var mApi: API

    override fun register(username: String, password: String, repassword: String) {
        if (mRegisterView?.checkContent() == true) {
            mApi.register(username, password, repassword)
                    .map(HttpResultFunction())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .`as`(AutoDispose.autoDisposable(mRegisterView?.getLifecycleProvider()))
                    .subscribe({
                        mRegisterView?.registerSuccess()
                    }, {
                        mRegisterView?.registerFail(it)
                    })
        }
    }

    override fun takeView(view: RegisterContract.View) {
        this.mRegisterView = view
    }

    override fun dropView() {
        mRegisterView = null
    }
}