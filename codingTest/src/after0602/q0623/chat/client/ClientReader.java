package after0602.q0623.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientReader implements Runnable {

    private Client client;
    private DataInputStream input;
    private boolean closed;


    public ClientReader(Client client, DataInputStream input) {
        this.client = client;
        this.input = input;
    }

    @Override
    public void run() {
        try {
            while (true) {
                try {
                    String receive = input.readUTF();
                    System.out.println(receive);
                } catch (SocketTimeoutException e) {
                }
            }
        } catch (IOException e) {
            System.out.println("client read 중 예외 발생");
        } finally {
            client.close();
        }
    }


    public void close() {
        if (closed) {
            return;
        }
        System.out.println("ClientReader 종료");
        closed = true;
    }
}
