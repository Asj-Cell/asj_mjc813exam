package newchat.client;

import java.io.DataInputStream;
import java.io.IOException;

public class ReadHandler implements Runnable{

    private final DataInputStream input;
    private final Client client;
    private boolean closed=false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;

    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            System.out.println(e);
        }finally {
            client.close();
        }
    }

    public void close() {
        if (closed) {
            return;
        }
        // 종료 로직 있으면 작성
        System.out.println("ReadHandler 자원 종료");
        closed = true;
    }
}
