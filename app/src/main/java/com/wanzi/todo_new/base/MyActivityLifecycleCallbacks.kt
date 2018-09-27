package com.wanzi.todo_new.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.wanzi.todo_new.R

/**
 *  Author : Created by WZ on 2018-09-26 16:28
 *  E-Mail : 1253427499@qq.com
 */
class MyActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        initToolbar(activity)
    }

    private fun initToolbar(activity: Activity?) {
        activity?.findViewById<Toolbar>(R.id.toolbar)?.run {
            if (activity is AppCompatActivity) {
                activity.setSupportActionBar(this)
                activity.supportActionBar?.run {
                    setDisplayHomeAsUpEnabled(true)
                    title = activity.title
                }
            }
        }
    }
}