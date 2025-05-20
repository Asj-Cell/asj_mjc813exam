package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;

public class ExitCommand implements Command{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public ExitCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] split, Session session) throws IOException {
        sessionManager.sendAll(session.getUserName()+"님이 접속을 종료합니다");
        throw new IOException();
    }
}
