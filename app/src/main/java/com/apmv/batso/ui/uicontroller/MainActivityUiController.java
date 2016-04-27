package com.apmv.batso.ui.uicontroller;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.apmv.batso.R;
import com.apmv.batso.ui.activity.MainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class MainActivityUiController implements View.OnClickListener {
    private String TAG = MainActivityUiController.class.getSimpleName();
    private MainActivity activity;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public MainActivityUiController(MainActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        initToolbar();
    }

    private void initToolbar() {
        toolbar.setTitle(activity.getStringResource(R.string.app_name));
        toolbar.setNavigationIcon(R.drawable.ic_white_back);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                activity.onBackPressed();
                break;
        }
    }
}
