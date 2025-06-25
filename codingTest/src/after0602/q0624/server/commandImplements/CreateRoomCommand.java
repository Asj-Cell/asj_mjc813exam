package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.HashMap;

public class CreateRoomCommand implements CommandExecutor {

    HashMap<Integer, SessionManager> rooms;

    public CreateRoomCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }
    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        SessionManager sessionManager = new SessionManager();
        if (rooms.size() <= 10) {
            rooms.put(sessionManager.getIdNum(), sessionManager);
            session.send("방이 생성되었습니다.");
            firstRoomAccess(session, sessionManager);
        } else {
            session.send("최대 방 개수 도달 현재 생성 된 전체 방 개수: "+rooms.size());
        }
    }

    private void firstRoomAccess(Session session, SessionManager sessionManager) {
        SessionManager currentRoom = session.getCurrentRoom();
        if (currentRoom != null && currentRoom != sessionManager) {
            currentRoom.remove(session);
            currentRoom.sendAll("[" + session.getUserName() + "] 님이 방을 나갔습니다.");
        }
        if (!sessionManager.contains(session)) {
            sessionManager.add(session);
            session.setCurrentRoom(sessionManager);
            sessionManager.sendAll("[" + session.getUserName() + "] 님이 "+ sessionManager.getRoomName() +"에 입장하셨습니다.");
        }
    }
}
