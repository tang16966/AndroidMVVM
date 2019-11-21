package com.trs.android.ui.main

import android.app.Application
import androidx.databinding.ObservableField
import com.trs.android.data.Repository
import com.trs.mvvm.base.BaseViewModel

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : view_model
 */
class MainViewModel(application: Application, model: Repository?) :
    BaseViewModel<Repository>(application, model) {

    fun userName() : ObservableField<String>{
        return ObservableField<String>("dada")
    }
}