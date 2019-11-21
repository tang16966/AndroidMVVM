package com.trs.android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.gyf.immersionbar.ImmersionBar
import com.trs.android.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).init()
        setContentView(View(this))
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity:: class.java))
            finish()
        },2000)
    }
}
