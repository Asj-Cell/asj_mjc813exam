package after0602.q0623.chat.server;

import java.io.IOException;
import java.util.ArrayList;

public class CommandControl {

    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|";

    public CommandControl(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void control(String receivedMessage, Session session) throws IOException {
        if (receivedMessage.contains("/message" + DELIMITER + "*")) {
            sessionManager.sendAll("[" + session.getUserName() + "] 님이 욕설 사용으로 강제퇴장 당하셨습니다.");
            throw new IOException();
        } else if (receivedMessage.startsWith("/message" + DELIMITER)) {
            messageSend(receivedMessage, session);
        } else if (receivedMessage.equals("/exit")) {
            throw new IOException();
        } else if (receivedMessage.startsWith("/rename")) {
            rename(receivedMessage, session);
        } else if (receivedMessage.startsWith("/userlist")) {
            userList(session);
        } else {
            session.send("정상적인 명령어가 아닙니다.");
        }
    }

    private void userList(Session session) throws IOException {
        ArrayList<String> list = sessionManager.userNameAll();
        session.send("현재 접속중인 전체 사용자 목록 출력");
        for (String userName : list) {
            session.send(userName);
        }
    }

    private void messageSend(String receivedMessage, Session session) {
        String[] sendMessage = receivedMessage.split(DELIMITER);
        String userName = session.getUserName();
        sessionManager.sendAll("[" + userName + "] " + sendMessage[1]);
        System.out.println("[" + userName + "] " + sendMessage[1]);
    }

    private void rename(String receivedMessage, Session session) {
        String userName = session.getUserName();
        String[] split = receivedMessage.split(DELIMITER);
        String newName = split[1];
        sessionManager.sendAll("[" + userName + "] 님이 이름을 [" + newName + "] 으로 변경합니다.");
        session.setUserName(newName);
    }

    public void setUserName(String userName, Session session) {
        session.setUserName(userName);
        sessionManager.sendAll("[" + userName + "] 님이 입장하셨습니다.");
    }
}
