package com.mjc813.network3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import static java.nio.charset.StandardCharsets.*;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;
    private final ClientHandlerManager manager;
    private PrintWriter writer;
    private String clientAddress;
    public ClientHandler(Socket socket, ClientHandlerManager manager) {
        this.clientSocket = socket;
        this.manager = manager;
        this.clientAddress = socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream(), UTF_8)
            );
            this.writer = new PrintWriter(
                    clientSocket.getOutputStream(), true, UTF_8
            );
            manager.addClient(this.writer,this.clientSocket);
            String connectMessage = "[서버] " + clientAddress + " 님이 입장했습니다.";
            System.out.println(connectMessage);
            manager.sendMessage(connectMessage);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                if (clientMessage.equals("exit")) {
                    manager.removeClient(this.clientSocket);
                    break;
                }
                if (clientMessage.equals("exitAll")) {
                    manager.removeAllClient();
                    break;
                }
                String broadcastMsg = "[" + clientAddress + "] " + clientMessage;
                System.out.println("메시지 수신: " + broadcastMsg);
                manager.sendMessage(broadcastMsg);

            }

        } catch (SocketException e) {
            System.out.println(clientAddress + " 클라이언트의 연결이 비정상적으로 끊어졌습니다.");
        } catch (IOException e) {
            System.err.println(clientAddress + " 클라이언트 핸들러 오류: " + e.getMessage());
        } finally {
            if (writer != null) {
                manager.removeClient(clientSocket);
            }
            String disconnectMessage = "[서버] " + clientAddress + " 님이 퇴장했습니다.";
            System.out.println(disconnectMessage);
            manager.sendMessage(disconnectMessage);

            try {
                clientSocket.close();
            } catch (IOException e) {
            }
        }
    }
}
