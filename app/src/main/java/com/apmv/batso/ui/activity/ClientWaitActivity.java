package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.helper.Utils;
import com.apmv.batso.ui.listener.Client;
import com.apmv.batso.ui.listener.IConnectCallBack;
import com.apmv.batso.ui.uicontroller.ClientWaitActivityUiController;

public class ClientWaitActivity extends PrimaryActivity implements IConnectCallBack {
    private static final String TAG = ClientWaitActivity.class.getSimpleName();
    private ClientWaitActivityUiController uiController;
    private Context mContext;
    private String code;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        mContext = this;
        uiController = new ClientWaitActivityUiController(this);
        init();
    }

    private void init() {
        code = getIntent().getStringExtra(Constants.INPUT_CODE); // Include IP and Port
        int length = code.length();
        if (length > 4) {
            String ip = code.substring(0, length - 4);
            String port = code.substring(length - 4, length);
            client = new Client(Constants.TYPE_CONNECT, Utils.longToIp(Long.parseLong(ip)), Integer.parseInt(port), this);
            client.execute();
        }
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

    @Override
    public void onSuccess(String response) {

    }

    @Override
    public void onFailed(String response) {

    }
}
