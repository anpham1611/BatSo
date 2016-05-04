package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.ui.uicontroller.ClientActivityUiController;
import com.apmv.batso.ui.uicontroller.ClientActivityUiController$$ViewBinder;
import com.apmv.batso.ui.uicontroller.ServerActivityUiController;

public class ClientActivity extends GameActivity {
    private static final String TAG = ClientActivity.class.getSimpleName();
    private ClientActivityUiController uiController;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_wait);

        mContext = this;
        uiController = new ClientActivityUiController(this);

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

}
