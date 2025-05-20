package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;

public class changeCommand implements Command{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public changeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] split, Session session) throws IOException {
        String newName = split[1];
        sessionManager.sendAll(session.getUserName()+"님이 이름을 "+newName+"으로 변경합니다,");
        session.setUserName(newName);
    }
}
