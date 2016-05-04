package com.apmv.batso.ui.listener;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by an.pham1611 on 4/28/16.
 */
public class Server {
    private ServerSocket serverSocket;
    private String message = "";
    private int socketServerPORT = 8080;
    private IConnectCallBack listener;
    private int result;

    public Server(int port, IConnectCallBack listener) {
        this.socketServerPORT = port;
        this.listener = listener;
        Thread socketServerThread = new Thread(new SocketServerThread());
        socketServerThread.start();
    }

    public void onDestroy() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketServerThread extends Thread {

        @Override
        public void run() {
            try {
                // create ServerSocket using specified port
                serverSocket = new ServerSocket(socketServerPORT);

                while (true) {
                    // block the call until connection is created and return
                    // Socket object
                    Socket socket = serverSocket.accept();

                    // Server Reply
                    SocketServerReplyThread socketServerReplyThread =
                            new SocketServerReplyThread(socket, 0);
                    socketServerReplyThread.run();

                    listener.onSuccess("");
                }
            } catch (IOException e) {
                e.printStackTrace();
                listener.onFailed(e.getMessage());
            }
        }
    }

    private class SocketServerReplyThread extends Thread {

        private Socket hostThreadSocket;
        private int selectedNumber;

        public SocketServerReplyThread(Socket socket, int selectedNumber) {
            this.hostThreadSocket = socket;
            this.selectedNumber = selectedNumber;
        }

        @Override
        public void run() {
            OutputStream outputStream;
            try {
                outputStream = hostThreadSocket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.print(String.valueOf(selectedNumber));
                printStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
