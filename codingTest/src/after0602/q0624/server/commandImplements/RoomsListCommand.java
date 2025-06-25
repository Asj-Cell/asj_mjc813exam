package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.HashMap;

public class RoomsListCommand implements CommandExecutor {

    HashMap<Integer, SessionManager> rooms;

    public RoomsListCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }


    @Override
    public void control(String receivedMessage, Session session) throws IOException {
        if (rooms.isEmpty()) {
            session.send("현재 만들어진 방이 없습니다 방 생성 후 다시 시도해주세요. ");
        } else {
            session.send("현재 방목록을 출력합니다. ");
            for (SessionManager value : rooms.values()) {
                session.send(value.toString());
            }
        }
    }
}
