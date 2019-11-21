package com.trs.android.http

import com.trs.android.BuildConfig
import com.trs.mvvm.http.cookie.CookieJarImpl
import com.trs.mvvm.http.cookie.store.PersistentCookieStore
import com.trs.mvvm.http.interceptor.BaseInterceptor
import com.trs.mvvm.http.interceptor.CacheInterceptor
import com.trs.mvvm.http.interceptor.logging.Level
import com.trs.mvvm.http.interceptor.logging.LoggingInterceptor
import com.trs.mvvm.utils.HttpsUtils
import com.trs.mvvm.utils.KLog
import com.trs.mvvm.utils.Utils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : RetrofitClient封装单例类, 实现网络请求
 */
class RetrofitClient {
    /**
     * 超时时间
     */
    private val DEFAULT_TIMEOUT = 20
    /**
     * 缓存时间
     */
    private val CACHE_TIMEOUT = 10 * 1024 * 1024
    private val mContext = Utils.getContext()
    private var okHttpClient : OkHttpClient
    private var retrofit : Retrofit
    private var cache : Cache ?= null
    private var httpCacheDirectory : File

    private constructor(){
        httpCacheDirectory = File(mContext.cacheDir,"http_cache")
        try {
            cache = Cache(httpCacheDirectory, CACHE_TIMEOUT.toLong())
        }catch (e : Exception){
            KLog.e("Could not create http cache",e)
        }
        val sslParams = HttpsUtils.getSslSocketFactory()

        //kotlin数组
        val map = mapOf("token" to "123")
        okHttpClient = OkHttpClient.Builder()
            .cookieJar(CookieJarImpl(PersistentCookieStore(mContext)))
            .addInterceptor(BaseInterceptor(map))
            .addInterceptor(CacheInterceptor(mContext))
            .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
            .addInterceptor(
                LoggingInterceptor
                    .Builder()//构建者模式
                .loggable(BuildConfig.DEBUG) //是否开启日志打印
                .setLevel(Level.BASIC) //打印的等级
                .log(Platform.INFO) // 打印类型
                .request("Request") // request的Tag
                .response("Response")// Response的Tag
                .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
                .build()
            )
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
            .build()
        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(URLs.BASE_URL)
            .build()
    }
    companion object{
        val instance : RetrofitClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitClient()
        }
    }

    /**
     * 获取retrofit服务
     */
    fun <T> create(service: Class<T>?): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return retrofit.create(service)
    }

    /**
     * 执行
     */
    fun <T> execute(observable: Observable<T>, subscriber: Observer<T>): T? {
        observable.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
        return null
    }
}