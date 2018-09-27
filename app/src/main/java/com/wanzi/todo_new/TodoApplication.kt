package com.wanzi.todo_new

import com.wanzi.todo_new.base.MyActivityLifecycleCallbacks
import com.wanzi.todo_new.base.Preferences
import com.wanzi.todo_new.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 *  Author : Created by WZ on 2018-09-26 10:45
 *  E-Mail : 1253427499@qq.com
 */
class TodoApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Preferences.setContext(this)
        registerActivityLifecycleCallbacks(MyActivityLifecycleCallbacks())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}