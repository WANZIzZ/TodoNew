package com.wanzi.todo_new.register

import android.os.Bundle
import android.view.View
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import com.wanzi.todo_new.R
import com.wanzi.todo_new.base.BaseActivity
import com.wanzi.todo_new.toast
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View {

    @Inject
    lateinit var mRegisterPresenter: RegisterPresenter

    override fun getLayout(): Int = R.layout.activity_register

    override fun initView() {}

    override fun initListener() {
        btn_register.setOnClickListener {
            mRegisterPresenter.register(et_user.text.toString(), et_password.text.toString(), et_verify_password.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        mRegisterPresenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mRegisterPresenter.dropView()
    }

    override fun checkContent(): Boolean {
        til_user.error = null
        til_password.error = null
        til_verify_password.error = null

        var cancel = false

        var focusView: View? = null

        val user = et_user.text.toString()
        val password = et_password.text.toString()
        val verifyPassword = et_verify_password.text.toString()

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

        if (verifyPassword.isEmpty()) {
            til_verify_password.error = "重复密码不能为空"
            focusView = til_verify_password
            cancel = true
        } else if (verifyPassword != password) {
            til_verify_password.error = "两次密码不相同"
            focusView = til_verify_password
            cancel = true
        }

        return if (cancel) {
            focusView?.requestFocus()
            false
        } else {
            true
        }
    }

    override fun getLifecycleProvider(): AndroidLifecycleScopeProvider {
        return getLifecycleScopeProvider()
    }

    override fun registerSuccess() {
        toast("注册成功")
        finish()
    }

    override fun registerFail(e: Throwable) {
        when (e.message) {
            "用户名已经被注册！" -> {
                til_user.error = e.message
            }
            "账号或者密码长度必须大于6位！" -> {
                if (et_user.text.toString().length < 6 && et_password.text.toString().length < 6) {
                    til_user.error = e.message
                    til_password.error = e.message
                } else if (et_user.text.toString().length < 6) {
                    til_user.error = e.message
                } else {
                    til_password.error = e.message
                }
            }
            "两次输入的密码不一致！" -> {
                til_verify_password.error = e.message
            }
            else -> {
                toast("注册失败:${e.message}")
            }
        }
    }
}
