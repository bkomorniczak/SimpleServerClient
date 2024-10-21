package com.test.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        String serverAddress = "tcp-server-service";  // Kubernetes service name
        int serverPort = 80;

        try {
            // Connect to the TCP server
            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream out = socket.getOutputStream();

            // Send a simple message to the server
            String message = "Hello from TCP Client";
            out.write(message.getBytes());
            out.flush();

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}