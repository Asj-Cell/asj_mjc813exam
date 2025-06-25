package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.HashMap;

public class RoomRemoveCommand implements CommandExecutor {

    HashMap<Integer, SessionManager> rooms;

    public RoomRemoveCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        String[] split = receivedMessage.split(":");
        if (split.length < 2) {
            session.send("방 삭제 요청이 잘못되었습니다. 형식: 5:<방번호>");
            return;
        }
        roomMove(session, split);
    }

    private void roomMove(Session session, String[] split) throws IOException {
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
}
