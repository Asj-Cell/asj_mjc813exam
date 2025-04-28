package chat.server;

import chat.client.CloseAll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static chat.server.Server.serverSocket;
import static chat.server.Server.sessionManager;

public class Server {

     static ServerSocket serverSocket;
     static SessionManager sessionManager;

    public static void main(String[] args) throws IOException {
         serverSocket = new ServerSocket(12345);
         sessionManager = new SessionManager();
         System.out.println("서버 시작");

        ShutdownHook shutdownHook = new ShutdownHook();
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook,"shutdownHook"));


        while (true) {
            Socket socket = serverSocket.accept();
            Session session = new Session(socket,sessionManager);
            Thread threadR = new Thread(session);
            threadR.start();
        }
    }

}

