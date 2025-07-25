package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.HashMap;

public class ExitCommand implements CommandExecutor {

    HashMap<Integer, SessionManager> rooms;

    public ExitCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        session.send("접속을 종료합니다.");
        throw new IOException();
    }
}
