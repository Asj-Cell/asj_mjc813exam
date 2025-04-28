package newchat.client.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int PORT;
    private final SessionManager sessionManager;
    private final CommendManager commendManager;


    public Server(int port, SessionManager sessionManager, CommendManager commendManager) {
        PORT = port;
        this.sessionManager = sessionManager;
        this.commendManager = commendManager;

    }

    public void start() throws IOException {
        try {
            System.out.println("서버 시작");
            ServerSocket serverSocket = new ServerSocket(PORT);

            ShutdownHook shutdownHook = new ShutdownHook(sessionManager, serverSocket);
            Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));

            while (true) {
                Socket socket = serverSocket.accept();
                Session session = new Session(socket, sessionManager, commendManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static class ShutdownHook implements Runnable{
        private final SessionManager sessionManager;
        private final ServerSocket serverSocket;

        public ShutdownHook(SessionManager sessionManager, ServerSocket serverSocket) {
            this.sessionManager = sessionManager;
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            try {
                sessionManager.closeAll();
                serverSocket.close();
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
