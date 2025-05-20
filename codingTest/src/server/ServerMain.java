package server;

import java.io.IOException;

public class ServerMain {

    private static int port = 12345;
    public static void main(String[] args) throws IOException {
        ServerV0 server = new ServerV0(port);
        System.out.println("서버 시작: "+port);
        server.start();
    }
}
