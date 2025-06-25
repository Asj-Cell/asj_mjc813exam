package after0602.q0623.chat.client;

import java.io.IOException;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 54321);
        client.start();

    }
}
