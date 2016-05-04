package com.apmv.batso.ui.listener;

import android.os.AsyncTask;

import com.apmv.batso.helper.Constants;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by an.pham1611 on 4/28/16.
 */
public class Client extends AsyncTask<Void, Void, Void> {

    private String dstAddress;
    private int dstPort;
    private String response = "";
    private IConnectCallBack listener;
    private int result;

    public Client(String dstAddress, int port, IConnectCallBack listener) {
        this.dstAddress = dstAddress;
        this.dstPort = port;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        Socket socket = null;

        try {
            socket = new Socket(dstAddress, dstPort);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead;
            InputStream inputStream = socket.getInputStream();

            /*
            * notice: inputStream.read() will block if no data return
            */
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
                result = Constants.TYPE_CONNECT_SUCCESS;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            result = Constants.TYPE_CONNECT_FAILED;

        } catch (IOException e) {
            e.printStackTrace();
            result = Constants.TYPE_CONNECT_FAILED;

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        switch (this.result) {
            case Constants.TYPE_CONNECT_SUCCESS:
                listener.onSuccess(response);
                break;
            case Constants.TYPE_CONNECT_FAILED:
                listener.onSuccess(response);
                break;
        }
    }

}
