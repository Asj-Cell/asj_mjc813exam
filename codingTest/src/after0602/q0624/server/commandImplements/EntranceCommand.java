package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.HashMap;

public class EntranceCommand implements CommandExecutor {

    HashMap<Integer, SessionManager> rooms;

    public EntranceCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }


    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        String[] split = receivedMessage.split(":");
        if (split.length < 2) {
            session.send("3:(입장할 방번호) 형식으로 사용해주세요.");
            return;
        }
        String roomId = split[1];
        entrance(session, roomId);

    }

    private void entrance(Session session, String roomId) throws IOException {
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

}
