package com.wanzi.todo_new.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by WANZI on 2016/12/30.
 */

class MainFragmentPagerAdapter(fm: FragmentManager, private val mTitle: Array<String>, private val mView: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return mView[position]
    }

    override fun getCount(): Int {
        return mView.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitle[position]
    }
}
