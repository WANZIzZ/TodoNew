package com.wanzi.todo_new.register

import com.wanzi.todo_new.di.ActivityScoped
import dagger.Module
import dagger.Provides

/**
 *  Author : Created by WZ on 2018-09-27 15:27
 *  E-Mail : 1253427499@qq.com
 */
@Module
class RegisterModule {

    @ActivityScoped
    @Provides
    fun registerPresenter(presenter: RegisterPresenter):RegisterContract.Presenter = presenter
}