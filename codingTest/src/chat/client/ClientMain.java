package chat.client;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import static chat.client.CloseAll.closeAll;

public class ClientMain {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);
        Client client = new Client(socket);
        client.start();


    }

}
