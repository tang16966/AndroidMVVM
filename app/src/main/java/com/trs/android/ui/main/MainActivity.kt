package com.trs.android.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.trs.android.BR

import com.trs.android.R
import com.trs.android.app.AppViewModelFactory
import com.trs.android.databinding.ActivityMainBinding

import com.trs.mvvm.base.BaseActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProviders.of(this,AppViewModelFactory.getInstance(application)).get(MainViewModel::class.java)
    }
}
