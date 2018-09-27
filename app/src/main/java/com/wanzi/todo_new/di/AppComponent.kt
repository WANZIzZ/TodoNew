package com.wanzi.todo_new.di

import android.app.Application
import com.wanzi.todo_new.TodoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 *  Author : Created by WZ on 2018-09-14 10:48
 *  E-Mail : 1253427499@qq.com
 */
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class
])
interface AppComponent : AndroidInjector<TodoApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}