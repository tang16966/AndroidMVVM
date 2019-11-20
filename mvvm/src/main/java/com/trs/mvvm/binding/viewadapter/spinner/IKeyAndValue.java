package com.trs.mvvm.binding.viewadapter.spinner;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : 下拉Spinner控件的键值对, 实现该接口,返回key,value值, 在xml绑定List<IKeyAndValue>
 */
public interface IKeyAndValue {
    String getKey();

    String getValue();
}
