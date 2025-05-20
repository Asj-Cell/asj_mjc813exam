package newchat.client.server;

import newchat.client.command.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommendManager {
    private final SessionManager sessionManager;
    private static final String DELIMITER = "\\|";
    private final Map<String, Command> commands =new HashMap<>();
    private final DefaultCommand defaultCommand=new DefaultCommand();

    public CommendManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/exit", new ExitCommand(sessionManager));
        commands.put("/change", new changeCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
    }

    public void execute(String toSend,Session session) throws IOException {

        String[] split = toSend.split(DELIMITER);
        String key = split[0];
        Command command = commands.getOrDefault(key,defaultCommand);
        command.execute(split,session);

    }
}
