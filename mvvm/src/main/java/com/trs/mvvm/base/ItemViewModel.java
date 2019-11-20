package com.trs.mvvm.base;


import androidx.annotation.NonNull;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */

public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
