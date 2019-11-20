package com.trs.mvvm.base;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */

public interface IBaseView {
    /**
     * 初始化界面传递参数
     */
    void initParam();
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化界面观察者的监听
     */
    void initViewObservable();
}
