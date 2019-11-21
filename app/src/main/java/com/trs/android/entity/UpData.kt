package com.trs.android.entity

/**
 * @author TRS
 * Create time : 2019/11/21
 * Explain : 更新对象
 */
data class UpData(
    val apkSize: Double,
    val apkUrl: String,
    val forceUpdate: Int,
    val isUpdata: Int,
    val md5: String,
    val newVersion: Int,
    val updateDescripion: String,
    val versionName: String
)