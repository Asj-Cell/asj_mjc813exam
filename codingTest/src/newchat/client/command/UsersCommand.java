package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;
import java.util.ArrayList;

public class UsersCommand implements Command{
    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] split, Session session) throws IOException {
        ArrayList<String> userList = sessionManager.getUserList();
        StringBuilder users = new StringBuilder("전체 사용자 목록을 출력합니다. \n");
        for (String s : userList) {
            users.append("- ").append(s).append("\n");
        }
        session.toSend(users.toString());
    }
}
