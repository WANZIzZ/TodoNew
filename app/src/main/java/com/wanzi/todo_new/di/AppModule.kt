package com.wanzi.todo_new.di

import com.wanzi.todo_new.retrofit.API
import com.wanzi.todo_new.retrofit.HttpSender
import com.wanzi.todo_new.util.LogUtil
import dagger.Module
import dagger.Provides

/**
 *  Author : Created by WZ on 2018-09-14 10:47
 *  E-Mail : 1253427499@qq.com
 */
@Module
class AppModule {

    @Provides
    fun provideLogUtil(): LogUtil = LogUtil()

    @Provides
    fun provideApi(): API = HttpSender.instances
}