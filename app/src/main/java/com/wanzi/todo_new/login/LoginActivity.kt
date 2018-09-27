package com.wanzi.todo_new.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.wanzi.todo_new.R
import com.wanzi.todo_new.base.BaseActivity
import com.wanzi.todo_new.config.Config
import com.wanzi.todo_new.register.RegisterActivity
import com.wanzi.todo_new.toast
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var mLoginPresenter: LoginPresenter

    override fun getLayout(): Int = R.layout.activity_login

    override fun initView() {}

    override fun initListener() {
        btn_login.setOnClickListener {
            mLoginPresenter.login(et_user.text.toString(), et_password.text.toString())
        }

        tv_register.setOnClickListener {
            mLoginPresenter.register()
        }
    }

    override fun onResume() {
        super.onResume()
        mLoginPresenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mLoginPresenter.dropView()
    }

    override fun checkContent(): Boolean {
        til_user.error = null
        til_password.error = null

        var cancel = false

        var focusView: View? = null

        val user = et_user.text.toString()
        val password = et_password.text.toString()

        if (user.isEmpty()) {
            til_user.error = "用户名不能为空"
            focusView = til_user
            cancel = true
        } else if (user.length < 6) {
            til_user.error = "用户名不能低于六位"
            focusView = til_user
            cancel = true
        }

        if (password.isEmpty()) {
            til_password.error = "密码不能为空"
            focusView = til_password
            cancel = true
        } else if (password.length < 6) {
            til_password.error = "密码不能低于六位"
            focusView = til_password
            cancel = true
        }

        return if (cancel) {
            focusView?.requestFocus()
            false
        } else {
            true
        }
    }

    override fun showRegisterUi() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun getLifecycleProvider(): AndroidLifecycleScopeProvider {
        return getLifecycleScopeProvider()
    }

    override fun loginSuccess() {
        setResult(
                Config.MAIN_LOGIN_RESULT_CODE,
                Intent()
                        .putExtra(Config.INTENT_NAME_LOGIN, true)
                        .putExtra(Config.INTENT_NAME_USERNAME, et_user.text.toString())
        )
        finish()
    }

    override fun loginFail(e: Throwable) {
        if ("账号密码不匹配！" == e.message) {
            til_user.error = e.message
            til_password.error = e.message
        } else {
            toast("登录失败:${e.message}")
        }
    }
}
