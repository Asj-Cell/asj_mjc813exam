package after0602.q0624.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ServerSocket serverSocket;
    private final CommandControl commandControl;
    private final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public Server(int port , CommandControl commandControl) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.commandControl = commandControl;
    }

    public void start() throws IOException {
        running();
    }

    private void running() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            Session session = new Session(socket,commandControl);
            executorService.execute(session);
        }
    }


}
