package after0602.q0624.server;

import after0602.q0623.chat.SocketClosed;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;


public class Session implements Runnable{

    private final Socket socket;
    private SessionManager currentRoom;
    private final DataOutputStream output;
    private final DataInputStream input;
    private final CommandControl commandControl;
    private String userName;
    private static Integer shareNum=1
            ;
    public Session(Socket socket,CommandControl commandControl) throws IOException {
        this.socket = socket;
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new DataInputStream(socket.getInputStream());
        this.commandControl = commandControl;
        userName = "무명자" + shareNum;
        shareNum++;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+" 입장");
        try {
            while (true) {
                String receivedMessage = input.readUTF();
                commandControl.control(receivedMessage, this);

            }
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+" 실행중 문제 발생, 자원을 종료합니다.");
        } finally {
            if (currentRoom != null) {
                currentRoom.remove(this);
                currentRoom.sendAll("["+getUserName()+"] 님이 접속을 종료합니다.");
            }
            close();
        }
    }

    public void send(String message) throws IOException {
        output.writeUTF(message);
    }


    public synchronized void close() {
        System.out.println(Thread.currentThread().getName()+" 자원종료");
        SocketClosed.close(socket,input,output);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SessionManager getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(SessionManager currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public String toString() {
        return userName + " 사용자 ";
    }
}
