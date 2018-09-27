package com.wanzi.todo_new.di

import com.wanzi.todo_new.login.LoginActivity
import com.wanzi.todo_new.login.LoginModule
import com.wanzi.todo_new.main.MainActivity
import com.wanzi.todo_new.main.MainModule
import com.wanzi.todo_new.register.RegisterActivity
import com.wanzi.todo_new.register.RegisterModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Author : Created by WZ on 2018-09-14 11:10
 *  E-Mail : 1253427499@qq.com
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    abstract fun bindRegisterActivity(): RegisterActivity
}