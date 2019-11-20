package com.trs.mvvm.binding.viewadapter.radiogroup;

import android.widget.RadioButton;
import android.widget.RadioGroup;

;import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;

import com.trs.mvvm.binding.command.BindingCommand;

/**
 * @author TRS
 * Create time : 2019/11/20
 * Explain :
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onCheckedChangedCommand"}, requireAll = false)
    public static void onCheckedChangedCommand(final RadioGroup radioGroup, final BindingCommand<String> bindingCommand) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                bindingCommand.execute(radioButton.getText().toString());
            }
        });
    }
}
