package com.trs.android.data.source

import com.trs.android.entity.UpData
import com.trs.mvvm.http.BaseResponse
import io.reactivex.Observable

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 网络接口
 */
interface HttpDataSource{
    fun upData() : Observable<BaseResponse<UpData>>
}