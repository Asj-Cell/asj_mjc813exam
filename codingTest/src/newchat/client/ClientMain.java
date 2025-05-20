package newchat.client;

import java.io.IOException;

public class ClientMain {
    private static final int PORT= 45678;
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost",PORT);
        client.start();
    }
}
