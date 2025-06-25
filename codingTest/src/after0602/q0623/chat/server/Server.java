package after0602.q0623.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;
    private final SessionManager sessionManager;
    private final ServerSocket serverSocket;
    private final CommandControl commandControl;

    public Server(int port, SessionManager sessionManager, CommandControl commandControl) throws IOException {
        this.port = port;
        this.sessionManager = sessionManager;
        this.serverSocket = new ServerSocket(port);
        this.commandControl = commandControl;
    }

    public void start() throws IOException {
        running();
        shutdownHook();
    }

    private void running() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Session session = new Session(socket, sessionManager,commandControl);
            Thread thread = new Thread(session);
            thread.start();
        }
    }

    private void shutdownHook() {
        ShutdownHook shutdownHook = new ShutdownHook(sessionManager, serverSocket);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));
    }

    static class ShutdownHook implements Runnable{

        private final SessionManager sessionManager;
        private final ServerSocket serverSocket;

        ShutdownHook(SessionManager sessionManager, ServerSocket serverSocket) {
            this.sessionManager = sessionManager;
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            try {
                sessionManager.closeAll();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("서버 소켓 종료 중 에러 발생"+e);
            }
        }

    }
}
