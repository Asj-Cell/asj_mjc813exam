package chat.server;

import chat.client.CloseAll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        SessionManager sessionManager = new SessionManager();
        System.out.println("서버 시작");



        while (true) {
            Socket socket = serverSocket.accept();
            Session session = new Session(socket,sessionManager);
            Thread thread = new Thread(session);
            thread.start();

        }
    }





}
