package com.wanzi.todo_new.login

import com.wanzi.todo_new.di.ActivityScoped
import dagger.Module
import dagger.Provides

/**
 *  Author : Created by WZ on 2018-09-26 17:06
 *  E-Mail : 1253427499@qq.com
 */
@Module
class LoginModule {

    @ActivityScoped
    @Provides
    fun loginPresenter(presenter: LoginPresenter): LoginContract.Presenter = presenter
}