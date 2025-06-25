package after0602.q0623.chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private final List<Session> sessionList = new ArrayList<>();
//    private final String roomName;
//
//    public SessionManager(String roomName) {
//        this.roomName = roomName;
//    }

    public synchronized void add(Session session) {
        sessionList.add(session);
    }

    public synchronized void remove(Session session) {
        sessionList.remove(session);
    }

    public void sendAll(String message) {
        try {
            for (Session session : sessionList) {
                session.send(message);
            }
        } catch (IOException e) {
            System.out.println("SendAll 중 예외발생"+e.toString());
        }
    }

    public synchronized void closeAll() {
        for (Session session : sessionList) {
            session.close();
        }
        sessionList.clear();
    }

    public ArrayList<String> userNameAll() {
        ArrayList<String> userList = new ArrayList<>();
        for (Session session : sessionList) {
            userList.add(session.getUserName());
        }

        return userList;
    }
}
