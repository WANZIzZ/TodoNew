package com.wanzi.todo_new.main

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.ViewTarget
import com.wanzi.todo_new.R
import com.wanzi.todo_new.base.BaseActivity
import com.wanzi.todo_new.base.Preferences
import com.wanzi.todo_new.config.Config
import com.wanzi.todo_new.done.DoneFragment
import com.wanzi.todo_new.login.LoginActivity
import com.wanzi.todo_new.toast
import com.wanzi.todo_new.todo.TodoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, MainContract.View {

    private lateinit var mGlide: ViewTarget<ImageView, Drawable>

    private var mLogin: Boolean by Preferences(Config.LOGIN_KEY, false)
    private var mUsername: String by Preferences(Config.USERNAME_KEY, "")

    lateinit var tvNavHeader: TextView

    @Inject
    lateinit var mMainPresenter: MainPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun initView() {
        toolbar_main.run {
            setSupportActionBar(this)
            supportActionBar!!.setDisplayShowTitleEnabled(true)
        }

        drawer_layout.run {
            val toggle = ActionBarDrawerToggle(
                    this@MainActivity,
                    this,
                    toolbar_main,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close
            )

            this.addDrawerListener(toggle)
            toggle.syncState()
        }

        nav_view.run {
            getHeaderView(0).findViewById<TextView>(R.id.tv_nav_header)
                    .run {
                        tvNavHeader = this
                        text = if (mLogin) mUsername else resources.getString(R.string.ac_main_tv_nav_header_default)
                        setOnClickListener(this@MainActivity)
                    }
            setNavigationItemSelectedListener(this@MainActivity)
        }

        mGlide = Glide
                .with(this)
                .load(Config.NAV_HEADER_IMG)
                .apply(RequestOptions.bitmapTransform(CircleCrop())) // 圆形处理
                .into(nav_view.getHeaderView(0).findViewById(R.id.iv_nav_header))

        val tabs = resources.getStringArray(R.array.tab)
        val fragments = ArrayList<Fragment>()
                .apply {
                    add(TodoFragment())
                    add(DoneFragment())
                }
        vp.adapter = MainFragmentPagerAdapter(supportFragmentManager, tabs, fragments)
        tabL.setupWithViewPager(vp)
    }

    override fun initListener() {}

    override fun onStart() {
        super.onStart()
        mGlide.onStart()
    }

    override fun onResume() {
        super.onResume()
        mMainPresenter.takeView(this)
    }

    override fun onStop() {
        super.onStop()
        mGlide.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mGlide.onDestroy()
        mMainPresenter.dropView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            Config.MAIN_LOGIN_RESULT_CODE -> {
                data?.run {
                    mUsername = getStringExtra(Config.INTENT_NAME_USERNAME)
                    mLogin = getBooleanExtra(Config.INTENT_NAME_LOGIN, false)
                }
                tvNavHeader.text = mUsername
            }
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_exit -> {
                if (mLogin) {
                    mMainPresenter.signOut()
                } else {
                    toast(resources.getString(R.string.toast_remind_login))
                }
            }
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_nav_header -> {
                if (!mLogin) {
                    drawer_layout.closeDrawers()
                    mMainPresenter.toLogin()
                }
            }
        }
    }

    override fun showLoginUi() {
        startActivityForResult(Intent(this, LoginActivity::class.java), Config.MAIN_LOGIN_REQUEST_CODE)
    }

    override fun setSignOut() {
        Preferences.clear()
        tvNavHeader.text = resources.getString(R.string.ac_main_tv_nav_header_default)
        toast("已退出登录")
    }
}
