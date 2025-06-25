package after0602.q0624.server.commandImplements;

import after0602.q0624.server.CommandExecutor;
import after0602.q0624.server.Session;
import after0602.q0624.server.SessionManager;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserRenameCommand implements CommandExecutor {

    HashMap<Integer,SessionManager> rooms;
    
    public UserRenameCommand(HashMap<Integer,SessionManager> rooms) {
        this.rooms = rooms;
    }

    @Override
    public void control(String receivedMessage, Session session) throws IOException {
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
