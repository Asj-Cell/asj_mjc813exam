package newchat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private final ReadHandler readHandler;
    private final WriteHandler writeHandler;
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;

    private boolean closed=false;

    public Client(String where, int port) throws IOException {
        this.socket =  new Socket(where,port);
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        readHandler = new ReadHandler(input, this);
        writeHandler = new WriteHandler(output, this);
    }

    public void start() throws IOException {
        Thread readThread = new Thread(readHandler);
        Thread writeThread = new Thread(writeHandler);

        readThread.start();
        writeThread.start();

    }

    public synchronized void close(){
        if (closed) {
            return;
        }
        CloseAll.closeAll(socket,input,output);
        readHandler.close();
        writeHandler.close();
        System.out.println("채팅 종료");
        closed = true;
    }
}
