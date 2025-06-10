package com.mjc813.network2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private final List<PrintWriter> clientWriters;
    private PrintWriter writer;
    private String clientAddress;

    public ClientHandler(Socket socket, List<PrintWriter> writers) {
        this.clientSocket = socket;
        this.clientWriters = writers;
        this.clientAddress = socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8)
            );

            this.writer = new PrintWriter(
                    clientSocket.getOutputStream(), true, StandardCharsets.UTF_8
            );

            clientWriters.add(this.writer);

            String connectMessage = "[서버] " + clientAddress + " 님이 입장했습니다.";
            System.out.println(connectMessage);
            ServerApp.broadcastMessage(connectMessage);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                String broadcastMsg = "[" + clientAddress + "] " + clientMessage;
                System.out.println("메시지 수신: " + broadcastMsg);

                ServerApp.broadcastMessage(broadcastMsg);
            }

        } catch (SocketException e) {
            System.out.println(clientAddress + " 클라이언트의 연결이 비정상적으로 끊어졌습니다.");
        } catch (IOException e) {
            System.err.println(clientAddress + " 클라이언트 핸들러 오류: " + e.getMessage());
        } finally {
            if (writer != null) {
                clientWriters.remove(writer);
            }

            String disconnectMessage = "[서버] " + clientAddress + " 님이 퇴장했습니다.";
            System.out.println(disconnectMessage);
            ServerApp.broadcastMessage(disconnectMessage);

            try {
                clientSocket.close();
            } catch (IOException e) {
            }
        }
    }
}