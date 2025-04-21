package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static chat.client.CloseAll.closeAll;

public class Client {

    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private ClientRead clientRead;
    private ClientWrite clientWrite;
    private boolean refit = false;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());

    }

    public void start() throws IOException {

            clientRead = new ClientRead(input,this);
            clientWrite = new ClientWrite(output,this);
            Thread clientReadThread = new Thread(clientRead);
            Thread clientWriteThread = new Thread(clientWrite);

            clientReadThread.start();
            clientWriteThread.start();




    }
    public synchronized void closeAll() {
        if (refit) {
            return;
        }
        try {
            clientRead.close();
            clientWrite.close();
            CloseAll.closeAll(socket, input, output);
            refit = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
