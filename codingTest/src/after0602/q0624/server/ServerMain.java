package after0602.q0624.server;

import java.io.IOException;

public class ServerMain {

    public static void main(String[] args) throws IOException {
        CommandControl commandControl = new CommandControl();
        Server server = new Server(54321,commandControl);
        server.start();
    }
}
