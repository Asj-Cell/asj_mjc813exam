package after0602.q0624.server;

import java.io.IOException;
import java.util.*;

public class SessionManager {

    private final List<Session> sessionList = new ArrayList<>();
    private Integer realNum;
    private static Integer shareNum=1;
    private String roomName;

    public SessionManager() {
        roomName = "방이름" + shareNum;
        realNum = shareNum;
        shareNum++;
    }

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

    public boolean isEmpty() {
        return sessionList.isEmpty();
    }

    public boolean contains(Session session) {
        return sessionList.contains(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessionList) {
            session.close();
        }
        sessionList.clear();
    }

    public Integer getIdNum() {

        return realNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    @Override
    public String toString() {
        return "현재 방 정보 ->[" +
                "현재 접속 중인 사용자: " + sessionList +
                ", 방 id=" + realNum +
                ", roomName='" + roomName + '\'' +
                ']';
    }
}
