package com.trs.mvvm.binding.viewadapter.viewgroup;

import androidx.databinding.ViewDataBinding;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */

public interface IBindingItemViewModel<V extends ViewDataBinding> {
    void injecDataBinding(V binding);
}
