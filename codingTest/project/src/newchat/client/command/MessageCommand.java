package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;

public class MessageCommand implements Command{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] split, Session session) throws IOException {
        String message = split[1];
        sessionManager.sendAll("["+session.getUserName()+"] "+message);
    }
}
