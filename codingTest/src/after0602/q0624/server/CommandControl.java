package after0602.q0624.server;

import java.io.IOException;
import java.util.*;

public class CommandControl {

    private final HashMap<Integer,SessionManager> rooms = new HashMap<>();

    public void control(String receivedMessage, Session session) throws IOException {
        if (receivedMessage.startsWith("1:")) {
            userRename(receivedMessage, session);
        } else if (receivedMessage.equals("4:")) {
            createRoom(session);
        } else if (receivedMessage.equals("2:")) {
            roomsList(session);
        } else if (receivedMessage.equals("q:")) {
            session.send("접속을 종료합니다.");
            throw new IOException();
        } else if (receivedMessage.startsWith("3:")) {
            entrance(receivedMessage, session);
        } else if (receivedMessage.startsWith("5:")) {
            roomRemove(receivedMessage,session);
        } else if (session.getCurrentRoom() != null) {
            SessionManager currentRoom = session.getCurrentRoom();
            currentRoom.sendAll("[" + session.getUserName() + "] " + receivedMessage);
        } else {
            session.send("대화내용 입력은 방 입장 후 이용해 주시기 바랍니다. ");
        }
    }

    private void roomRemove(String receivedMessage, Session session) throws IOException {
        String[] split = receivedMessage.split(":");
        if (split.length < 2) {
            session.send("방 삭제 요청이 잘못되었습니다. 형식: 5:<방번호>");
            return;
        }
        try {
            int removeRoomNumber = Integer.parseInt(split[1]);
            SessionManager room = rooms.get(removeRoomNumber);
            if (room == null) {
                session.send("해당 번호의 방이 존재하지 않습니다.");
                return;
            }
            if (!room.isEmpty()) {
                session.send("해당 방에 유저가 남아있어서 삭제할 수 없습니다.");
                return;
            }
            rooms.remove(removeRoomNumber);
            session.send(removeRoomNumber + "번 방이 삭제되었습니다.");
        } catch (NumberFormatException e) {
            session.send("방 번호가 유효하지 않습니다.");
        }
    }

    private void entrance(String receivedMessage, Session session) throws IOException {
        String[] split = receivedMessage.split(":");
        if (split.length < 2) {
            session.send("3:(입장할 방번호) 형식으로 사용해주세요.");
            return;
        }
        String roomId = split[1];

        for (SessionManager value : rooms.values()) {
            if (roomId.equals(String.valueOf((value.getIdNum())))) {
                SessionManager currentRoom = session.getCurrentRoom();
                if (currentRoom != null && currentRoom != value) {
                    currentRoom.remove(session);
                    currentRoom.sendAll("[" + session.getUserName() + "] 님이 방을 나갔습니다.");
                }
                if (!value.contains(session)) {
                    value.add(session);
                    session.setCurrentRoom(value);
                    value.sendAll("[" + session.getUserName() + "] 님이 "+value.getRoomName() +"에 입장하셨습니다.");
                } else {
                    session.setCurrentRoom(value);
                    session.send(value.getRoomName() + " 에 이미 입장 중입니다.");
                }
                return;
            }
        }
        session.send("해당 방 번호를 찾을 수 없습니다.");
    }



    private void roomsList(Session session) throws IOException {
        if (rooms.isEmpty()) {
            session.send("현재 만들어진 방이 없습니다 방 생성 후 다시 시도해주세요. ");
        } else {
            session.send("현재 방목록을 출력합니다. ");
            for (SessionManager value : rooms.values()) {
                session.send(value.toString());
            }
        }

    }

    private void createRoom(Session session) throws IOException {
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

    private void userRename(String receivedMessage, Session session) throws IOException {
        String[] split = receivedMessage.split(":");
        if (split.length < 2) {
            session.send("1:(변경할 이름) 형식으로 사용해주세요.");
            return;
        }
        String newName = split[1];
        if (session.getCurrentRoom() == null) {
            session.send("이름 변경은 방입장 후 사용 가능합니다.");
            return;
        }

        if (isUnique(session, newName)) return;
        session.send("사용자의 이름을 "+session.getUserName()+" 에서 "+newName+" 으로 변경합니다.");
        session.setUserName(newName);
    }

    private boolean isUnique(Session session, String newName) throws IOException {
        Collection<SessionManager> values = rooms.values();
        for (SessionManager value : values) {
            List<Session> sessionList = value.getSessionList();
            for (Session userSession : sessionList) {
                String userName = userSession.getUserName();
                if (newName.equals(userName)) {
                    session.send(newName +"의 이름은 이미 사용중인 이름입니다. 다른 이름을 선택해주세요");
                    return true;
                }
            }
        }
        return false;
    }


}
