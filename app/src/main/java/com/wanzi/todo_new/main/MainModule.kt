package com.wanzi.todo_new.main

import com.wanzi.todo_new.di.ActivityScoped
import dagger.Module
import dagger.Provides

/**
 *  Author : Created by WZ on 2018-09-26 15:04
 *  E-Mail : 1253427499@qq.com
 */
@Module
class MainModule {

    @ActivityScoped
    @Provides
    fun mainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}