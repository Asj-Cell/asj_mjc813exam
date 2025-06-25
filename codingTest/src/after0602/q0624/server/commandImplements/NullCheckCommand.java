package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;

public class NullCheckCommand implements CommandExecutor {
    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        SessionManager currentRoom = session.getCurrentRoom();
        currentRoom.sendAll("[" + session.getUserName() + "] " + receivedMessage);
    }
}
