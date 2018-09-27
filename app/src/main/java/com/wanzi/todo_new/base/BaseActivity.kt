package com.wanzi.todo_new.base

import android.os.Bundle
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Author : Created by WZ on 2018-09-26 17:02
 *  E-Mail : 1253427499@qq.com
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        // 由于 ActivityLifecycleCallbacks 中所有方法的调用时机都是在 Activity 对应生命周期的 Super 方法中进行的,所以在 Activity 的 onCreate 方法中使用 setContentView 必须在 super.onCreate(savedInstanceState); 之前,不然在 onActivityCreated 方法中 findViewById 会发现找不到
        setContentView(getLayout())
        super.onCreate(savedInstanceState)

        initView()
        initListener()
    }

    abstract fun initView()

    abstract fun initListener()

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    protected fun getLifecycleScopeProvider(): AndroidLifecycleScopeProvider {
        return AndroidLifecycleScopeProvider.from(this)
    }
}