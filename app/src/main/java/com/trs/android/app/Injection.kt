package com.trs.android.app

import com.trs.android.data.Repository
import com.trs.android.data.source.http.HttpDataSourceImpl
import com.trs.android.data.source.http.service.ApiService
import com.trs.android.http.RetrofitClient

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 注入全局的数据仓库
 */
object Injection{
    fun provideRepository() : Repository{
        val service = RetrofitClient.instance.create(ApiService::class.java)
        val httpDataSource = HttpDataSourceImpl.getInstance(service)
        return Repository.getInstance(httpDataSource)
    }
}