package after0602.q0624.server;

import after0602.q0624.server.commandImplements.*;

import java.io.IOException;
import java.util.*;

public class CommandControl {

    private final HashMap<Integer,SessionManager> rooms = new HashMap<>();
    private final LinkedHashMap<String, CommandExecutor> commands = new LinkedHashMap<>();
    CommandExecutor nullCommand = new NullCheckCommand();

    public CommandControl() {
        commands.put("1:", new UserRenameCommand(rooms));
        commands.put("4:", new CreateRoomCommand(rooms));
        commands.put("2:", new RoomsListCommand(rooms));
        commands.put("q:", new ExitCommand(rooms));
        commands.put("3:", new EntranceCommand(rooms));
        commands.put("5:", new RoomRemoveCommand(rooms));
    }

    public void control(String receivedMessage, Session session) throws IOException {
        Set<String> keys = commands.keySet();
        for (String key : keys) {
            if (receivedMessage.startsWith(key)) {
                CommandExecutor executor = commands.getOrDefault(key, nullCommand);
                executor.control(receivedMessage, session);
                return;
            }
        }
        if (session.getCurrentRoom() == null) {
            session.send("대화내용 입력은 방 입장 후 이용해 주시기 바랍니다.");
        }
    }
}
