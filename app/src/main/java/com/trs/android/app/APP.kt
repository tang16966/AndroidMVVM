package com.trs.android.app

import com.trs.android.BuildConfig
import com.trs.android.R
import com.trs.android.ui.SplashActivity
import com.trs.mvvm.base.BaseApplication
import com.trs.mvvm.crash.CaocConfig
import com.trs.mvvm.utils.KLog


/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : Application
 */
class APP : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        KLog.init(BuildConfig.DEBUG)
        initCrash()
    }

    private fun initCrash(){
        CaocConfig.Builder.create()
            .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
            .enabled(true) //是否启动全局异常捕获
            .showErrorDetails(true) //是否显示错误详细信息
            .showRestartButton(true) //是否显示重启按钮
            .trackActivities(true) //是否跟踪Activity
            .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
            .errorDrawable(R.mipmap.ic_launcher) //错误图标
            .restartActivity(SplashActivity:: class.java) //重新启动后的activity
            .apply()
    }
}