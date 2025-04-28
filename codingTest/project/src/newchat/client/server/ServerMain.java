package newchat.client.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT =45678;
    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommendManager commendManager = new CommendManager(sessionManager);
        Server server = new Server(PORT,sessionManager,commendManager);
        server.start();

    }
}
