package newchat.client.server;

import java.io.IOException;
import java.util.ArrayList;

public class SessionManager {

    private final ArrayList<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public synchronized void sendAll(String message) throws IOException {
        for (Session session : sessions) {
            session.toSend(message);
        }
    }

    public ArrayList<String> getUserList() {
        ArrayList<String> userList = new ArrayList<>();
        for (Session session : sessions) {
            String userName = session.getUserName();
            userList.add(userName);
        }
        return userList;
    }
}
