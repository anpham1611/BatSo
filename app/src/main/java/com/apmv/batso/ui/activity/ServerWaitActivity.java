package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.helper.Utils;
import com.apmv.batso.net.api.ApiResponse;
import com.apmv.batso.net.helper.ApiHelper;
import com.apmv.batso.ui.listener.IConnectCallBack;
import com.apmv.batso.ui.listener.Server;
import com.apmv.batso.ui.uicontroller.ServerWaitActivityUiController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import bolts.Continuation;
import bolts.Task;

public class ServerWaitActivity extends PrimaryActivity implements IConnectCallBack {
    private static final String TAG = ServerWaitActivity.class.getSimpleName();
    private ServerWaitActivityUiController uiController;
    private Context mContext;
    private Server server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_wait);

        mContext = this;
        uiController = new ServerWaitActivityUiController(this);

        init();
//        doGetPublicIp();
        updateCode();
    }

    private void init() {
        // Get IP & random port
        // String iP = getLocalIpAddress();
    }

    public void updateCode(/*String ip*/) {
        String ip = getIpAddress();

        // Set code
        long ipLong = Utils.ipToLong(ip);
        int port = Utils.randomPort();
        long ipLongAndPort = Long.valueOf(String.valueOf(ipLong) + "" + port);

        // For server
        if (server != null) server.onDestroy();
        server = new Server(port, this);
        uiController.setCode(ipLongAndPort + "");
    }

    public void doGetPublicIp() {
        ApiHelper.doGetPublicIp(Constants.API_GET_CLIENT_IP).continueWith(new Continuation<ApiResponse, Object>() {
            @Override
            public Object then(final Task<ApiResponse> task) throws Exception {
                if (!task.isFaulted()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            updateCode(task.getResult().getBody());
                        }
                    });
                }
                return null;
            }
        });
    }

    public String getIpAddress() {
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
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
    protected void onDestroy() {
        super.onDestroy();
        server.onDestroy();
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
