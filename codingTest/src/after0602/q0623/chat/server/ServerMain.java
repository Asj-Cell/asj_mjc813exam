package after0602.q0623.chat.server;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandControl commandControl = new CommandControl(sessionManager);
        Server server = new Server(54321,sessionManager,commandControl);
        server.start();
    }
}
