package com.apmv.batso.ui.uicontroller;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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
    @Bind(R.id.btnInvite)
    Button btnInvite;
    @Bind(R.id.btnPlay)
    Button btnPlay;
    @Bind(R.id.btnReadMe)
    Button btnReadMe;

    public MainActivityUiController(MainActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        initToolbar();
        btnInvite.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnReadMe.setOnClickListener(this);
    }

    private void initToolbar() {
        toolbar.setTitle(activity.getStringResource(R.string.app_name));
        toolbar.setNavigationIcon(R.drawable.ic_white_back);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnInvite:
                activity.actionInvite();
                break;

            case R.id.btnPlay:
                activity.actionPlay();
                break;

            case R.id.btnReadMe:
                activity.actionReadMe();
                break;

            default:
                activity.onBackPressed();
                break;
        }
    }
}
