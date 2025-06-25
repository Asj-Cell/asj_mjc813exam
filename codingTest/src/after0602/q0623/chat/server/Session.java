package after0602.q0623.chat.server;

import after0602.q0623.chat.SocketClosed;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Session implements Runnable{

    private final Socket socket;
    private final SessionManager sessionManager;
    private final DataOutputStream output;
    private final DataInputStream input;
    private final CommandControl commandControl;
    private String userName;
    private boolean closed;

    public Session(Socket socket, SessionManager sessionManager, CommandControl commandControl) throws IOException {
        this.socket = socket;
        this.sessionManager = sessionManager;
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new DataInputStream(socket.getInputStream());
        this.commandControl = commandControl;
        sessionManager.add(this);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            String userName = input.readUTF();
            commandControl.setUserName(userName,this);
            while (true) {

                String receivedMessage = input.readUTF();
                commandControl.control(receivedMessage,this);
            }
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+" 실행중 문제 발생, 자원을 종료합니다.");
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll("["+getUserName()+"] 님이 접속을 종료합니다.");
            close();
        }
    }

    public void send(String message) throws IOException {
        output.writeUTF(message);
    }


    public synchronized void close() {
        if (closed) {
            return;
        }
        System.out.println(Thread.currentThread().getName()+" 자원종료");
        closed = true;
        SocketClosed.close(socket,input,output);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
