package newchat.client.server;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static newchat.client.CloseAll.closeAll;

public class Session implements Runnable {
    private final Socket socket;
    private final DataOutputStream output;
    private final DataInputStream input;
    private final SessionManager sessionManager;
    private final CommendManager commendManager;
    private String userName;
    private boolean closed = false;

    public Session(Socket socket, SessionManager sessionManager, CommendManager commendManager ) throws IOException {
        this.socket = socket;
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new DataInputStream(socket.getInputStream());
        this.sessionManager = sessionManager;
        this.commendManager = commendManager;
        sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                commendManager.execute(received, this);
            }
        } catch (IOException e) {
            System.out.println(userName + "님이 접속을 종료하였습니다.");
        }finally {
            close();
        }
    }


    public synchronized void close() {
        if (closed) {
            return;
        }

        closeAll(socket,input,output);
        sessionManager.remove(this);
        closed = true;
    }

    public void toSend(String message) throws IOException {
        output.writeUTF(message);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
