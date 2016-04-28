package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.helper.Utils;
import com.apmv.batso.net.api.ApiResponse;
import com.apmv.batso.net.helper.ApiHelper;
import com.apmv.batso.ui.uicontroller.ServerWaitActivityUiController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import bolts.Continuation;
import bolts.Task;

public class ServerWaitActivity extends PrimaryActivity {
    private static final String TAG = ServerWaitActivity.class.getSimpleName();
    private ServerWaitActivityUiController uiController;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_wait);

        mContext = this;
        uiController = new ServerWaitActivityUiController(this);

        init();
        doGetPublicIp();
    }

    private void init() {
        // Get IP & random port
        // String iP = getLocalIpAddress();
    }

    private void updateCode(String ip) {

        // Set code
        long ipLong = Utils.ipToLong(ip);
        long ipLongAndPort = Long.valueOf(String.valueOf(ipLong) + "" + Utils.randomPort());
        uiController.setCode("" + (ipLongAndPort));
    }

    public void doGetPublicIp() {
        ApiHelper.doGetPublicIp(Constants.API_GET_CLIENT_IP).continueWith(new Continuation<ApiResponse, Object>() {
            @Override
            public Object then(final Task<ApiResponse> task) throws Exception {
                if (!task.isFaulted()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateCode(task.getResult().getBody());
                        }
                    });
                }
                return null;
            }
        });
    }

    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Log.i(TAG, "***** IP="+ ip);
                        return ip;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.toString());
        }
        return null;
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
