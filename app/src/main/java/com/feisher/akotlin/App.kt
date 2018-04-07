package com.feisher.akotlin

import android.app.Application

import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by Administrator on 2018/4/6 0006.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()     // 打印日志
        ARouter.openDebug()
        ARouter.init(this)
    }
}
