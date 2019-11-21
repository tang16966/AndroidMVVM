package com.trs.android.data.source.http

import com.trs.android.data.source.HttpDataSource
import com.trs.android.data.source.http.service.ApiService
import com.trs.android.entity.UpData
import com.trs.android.http.RetrofitClient
import com.trs.mvvm.http.BaseResponse
import io.reactivex.Observable

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 网络实现
 */
class HttpDataSourceImpl : HttpDataSource {
    private var apiService : ApiService

    private constructor(apiService : ApiService){
        this.apiService = apiService
    }

    /**
     * 带参数的单例
     */
    companion object{
        var instance: HttpDataSourceImpl? = null

        fun getInstance(apiService : ApiService): HttpDataSourceImpl {
            if (instance == null) {
                synchronized(HttpDataSourceImpl::class) {
                    if (instance == null) {
                        instance = HttpDataSourceImpl(apiService)
                    }
                }
            }
            return instance!!
        }
    }

    override fun upData(): Observable<BaseResponse<UpData>> {
        return apiService.upData()
    }
}