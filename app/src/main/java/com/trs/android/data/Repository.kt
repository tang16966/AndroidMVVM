package com.trs.android.data

import com.trs.android.data.source.HttpDataSource
import com.trs.android.data.source.http.HttpDataSourceImpl
import com.trs.android.entity.UpData
import com.trs.mvvm.base.BaseModel
import com.trs.mvvm.http.BaseResponse
import io.reactivex.Observable

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 数据仓库
 */
class Repository : BaseModel,HttpDataSource{

    private var httpDataSource: HttpDataSource
    private constructor(httpDataSource: HttpDataSource){
        this.httpDataSource = httpDataSource
    }

    companion object{
        var instance: Repository? = null

        fun getInstance(httpDataSource: HttpDataSource): Repository {
            if (instance == null) {
                synchronized(HttpDataSourceImpl::class) {
                    if (instance == null) {
                        instance = Repository(httpDataSource)
                    }
                }
            }
            return instance!!
        }
    }

    override fun upData(): Observable<BaseResponse<UpData>> {
        return httpDataSource.upData()
    }

}