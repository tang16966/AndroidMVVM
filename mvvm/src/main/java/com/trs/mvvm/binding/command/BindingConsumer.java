package com.trs.mvvm.binding.command;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain : A one-argument action.
 */
public interface BindingConsumer<T> {
    void call(T t);
}
