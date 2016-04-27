package com.apmv.batso.ui.uicontroller;

import android.view.View;

import com.apmv.batso.ui.activity.ReadMeActivity;

import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ReadMeActivityUiController implements View.OnClickListener {
    private String TAG = ReadMeActivityUiController.class.getSimpleName();
    private ReadMeActivity activity;

    public ReadMeActivityUiController(ReadMeActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
