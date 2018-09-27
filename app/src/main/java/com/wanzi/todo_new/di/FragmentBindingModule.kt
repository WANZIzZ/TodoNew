package com.wanzi.todo_new.di

import com.wanzi.todo_new.done.DoneFragment
import com.wanzi.todo_new.done.DoneModule
import com.wanzi.todo_new.todo.TodoFragment
import com.wanzi.todo_new.todo.TodoModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Author : Created by WZ on 2018-09-14 11:10
 *  E-Mail : 1253427499@qq.com
 */
@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = [TodoModule::class])
    abstract fun bindTodoFragment(): TodoFragment

    @ContributesAndroidInjector(modules = [DoneModule::class])
    abstract fun bindDoneFragment(): DoneFragment
}