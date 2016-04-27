package com.apmv.batso.ui.uicontroller;

import android.view.View;

import com.apmv.batso.ui.activity.ServerWaitActivity;

import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ServerWaitActivityUiController implements View.OnClickListener {
    private String TAG = ServerWaitActivityUiController.class.getSimpleName();
    private ServerWaitActivity activity;

    public ServerWaitActivityUiController(ServerWaitActivity activity) {
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
