package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.ui.listener.Client;
import com.apmv.batso.ui.uicontroller.ClientActivityUiController;

public class ClientActivity extends GameActivity {
    private static final String TAG = ClientActivity.class.getSimpleName();
    private ClientActivityUiController uiController;
    private Context mContext;
    private String code;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        mContext = this;
        uiController = new ClientActivityUiController(this);
        init();
    }

    private void init() {
        code = getIntent().getStringExtra(Constants.INPUT_CODE);
        client = new Client(this, "192.168.1.128", Integer.valueOf(code), uiController.getTxtMessage());
        client.execute();
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
