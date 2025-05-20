package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerV0 {

    private final ExecutorService es = Executors.newFixedThreadPool(10);
    ServerSocket serverSocket;
    private int port;


    public ServerV0(int port) {
        this.port = port;
    }

    public void start() throws IOException {
         serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            ServerHandler serverHandler = new ServerHandler(socket);

            es.submit(serverHandler);
        }
    }


}
