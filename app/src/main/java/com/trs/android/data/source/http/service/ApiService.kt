package com.trs.android.data.source.http.service

import com.trs.android.entity.UpData
import com.trs.android.http.URLs
import com.trs.mvvm.http.BaseResponse
import io.reactivex.Observable
import retrofit2.http.POST

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 网络请求
 */
interface ApiService{
    @POST(URLs.UP_DATA)
    fun upData() : Observable<BaseResponse<UpData>>
}