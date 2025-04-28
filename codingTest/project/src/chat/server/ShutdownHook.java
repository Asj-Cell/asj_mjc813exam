package chat.server;

import java.io.IOException;


import static chat.server.Server.serverSocket;
import static chat.server.Server.sessionManager;

public class ShutdownHook  implements Runnable{
   @Override
        public void run() {
            try {
                sessionManager.closeAll();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

}
