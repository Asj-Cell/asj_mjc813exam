package chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    private final List<Session> sessions = new ArrayList<>();

    public void add(Session session) {
        sessions.add(session);
    }

    public void remove(Session session) {
        sessions.remove(session);

    }

    public void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public void sendAll(String message) throws IOException {
        for (Session session : sessions) {
            session.tosend(message);
        }
    }

    public ArrayList<String> nameList() {
        ArrayList<String> names = new ArrayList<>();
        for (Session session : sessions) {
            names.add(session.getUsername());
        }
        return names;
    }


}
