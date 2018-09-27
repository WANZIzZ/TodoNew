package com.wanzi.todo_new.config

import android.widget.Toast

/**
 *  Author : Created by WZ on 2018-09-26 14:27
 *  E-Mail : 1253427499@qq.com
 */
object Config {


    /**
     * Share preferences name
     */
    val SHARED_NAME = "preferences"
    val LOGIN_KEY = "login"
    val USERNAME_KEY = "username"

    /**
     * NavigationView header imageView
     */
    val NAV_HEADER_IMG = "https://pic.qqtn.com/up/2016-7/2016071115340721509.gif"

    /**
     * toast
     */
    var showToast: Toast? = null

    /**
     * baseUrl
     */
    val BASE_URL = "http://www.wanandroid.com/"

    val MAIN_LOGIN_REQUEST_CODE = 99
    val MAIN_LOGIN_RESULT_CODE = 100

    val INTENT_NAME_LOGIN = "login"
    val INTENT_NAME_USERNAME = "username"
}