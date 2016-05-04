package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.net.NetUtils;
import com.apmv.batso.ui.uicontroller.MainActivityUiController;

public class MainActivity extends PrimaryActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityUiController uiController;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        uiController = new MainActivityUiController(this);

        init();
    }

    private void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void actionInvite() {
        if (!NetUtils.isConnectInternet) {
            showToastMessage(R.string.msg_no_internet);
            return;
        }
        Intent intent = new Intent(this, ServerWaitActivity.class);
        startActivity(intent);
    }

    public void actionPlay() {
        if (!NetUtils.isConnectInternet) {
            showToastMessage(R.string.msg_no_internet);
            return;
        }
        if (uiController.getInputCode().trim().equals("")) {
            showToastMessage(R.string.msg_code_required);
            return;
        }
        Intent intent = new Intent(this, ClientWaitActivity.class);
        intent.putExtra(Constants.INPUT_CODE, uiController.getInputCode());
        startActivity(intent);
    }

    public void actionReadMe() {
        Intent intent = new Intent(this, ReadMeActivity.class);
        startActivity(intent);
    }
}
