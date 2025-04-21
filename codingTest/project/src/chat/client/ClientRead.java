package chat.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static chat.client.CloseAll.closeAll;

public class ClientRead implements Runnable{
    private final Client client;
    private final DataInputStream input;
    private boolean refit = false;


    public ClientRead(DataInputStream input,Client client) {
        this.input = input;
        this.client =client;
    }


    @Override
    public void run() {
        try {
            while (true) {
                String word = input.readUTF();
                System.out.println(word);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }finally {
          client.closeAll();
        }
    }

    public void close() {
        if (refit) {
            return;
        }
            refit = true;

    }
}
