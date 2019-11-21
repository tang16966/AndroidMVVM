package com.trs.android.app

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trs.android.data.Repository

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : viewModel工厂
 */
class AppViewModelFactory : ViewModelProvider.NewInstanceFactory{
    private var application : Application
    private var repository: Repository
    private constructor(application : Application,repository: Repository){
        this.application = application
        this.repository = repository
    }
    companion object{
        var instance: AppViewModelFactory? = null

        fun getInstance(application : Application): AppViewModelFactory {
            if (instance == null) {
                synchronized(AppViewModelFactory::class) {
                    if (instance == null) {
                        instance = AppViewModelFactory(application,Injection.provideRepository())
                    }
                }
            }
            return instance!!
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom())
        return super.create(modelClass)
    }
}