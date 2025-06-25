package after0602.q0624.server;

import java.io.IOException;

public interface CommandExecutor {
     void control(String receivedMessage, Session session) throws IOException;
}
