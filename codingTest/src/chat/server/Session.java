
package chat.server;

import chat.client.CloseAll;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import static chat.client.CloseAll.closeAll;

public class Session implements Runnable{
    private final static String DELIMITER = "\\|";
    private final Socket socket;
    private final SessionManager sessionManager;
    private final DataOutputStream output;
    private final DataInputStream input;
    private boolean refit=false;
    private String username;

    public Session(Socket socket, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.sessionManager = sessionManager;
        this.output = new DataOutputStream(socket.getOutputStream());
        this.input = new DataInputStream(socket.getInputStream());
        sessionManager.add(this);
    }



    @Override
    public void run() {
        try {
            while (true) {
                String word = input.readUTF();
                if (word.startsWith("/join|")) {
                    String[] split = word.split(DELIMITER);
                    String name = split[1];
                    sessionManager.sendAll(name+"님이 입장하셨습니다.");
                    setUsername(name);

                } else if (word.startsWith("/message|")) {
                    if (word.length() == 9) {
                        word = "/message| ";
                    }
                    String[] split = word.split(DELIMITER);

                    String message = split[1];
                    sessionManager.sendAll("["+username+"] "+message);

                } else if (word.startsWith("/change|")) {
                    String[] split = word.split(DELIMITER);
                    String newName = split[1];
                    sessionManager.sendAll(username+"님이 이름을: "+newName+"으로 변경하였습니다.");
                    setUsername(newName);

                } else if (word.equals("/users")) {
                    ArrayList<String> nameList = sessionManager.nameList();
                    StringBuilder list = new StringBuilder("전체 유저 목록\n");
                    for (String name : nameList) {
                        list.append(name + "님" + "\n");
                    }
                    sessionManager.sendAll(list.toString());

                } else if (word.equals("/exit")) {
                    System.out.println(username+"님이 접속을 종료합니다.");
                    sessionManager.sendAll(username+"님이 접속을 종료합니다.");
                    sessionManager.remove(this);
                    close();
                    break;

                } else {
                    tosend("잘못된 문법의 입력 입니다.");
                }

            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }


    public synchronized void close() {
        if (refit) {
            return;
        }
        closeAll(socket,input,output);
        refit = true;
        sessionManager.remove(this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void tosend(String message) throws IOException {
        output.writeUTF(message);
    }
}


