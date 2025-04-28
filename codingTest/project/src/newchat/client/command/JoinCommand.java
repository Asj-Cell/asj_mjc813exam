package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;

public class JoinCommand implements Command{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] split, Session session) throws IOException {
        String name = split[1];
        session.setUserName(name);
        sessionManager.sendAll(session.getUserName()+"님이 입장하셨습니다.");
    }
}
