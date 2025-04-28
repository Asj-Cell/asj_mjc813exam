package newchat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CloseAll {

    public static void closeAll(Socket socket, DataInputStream input, DataOutputStream output) {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("input을 종료하다가 예외가 발생했다.");
            }
        }
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                System.out.println("output을 종료하다가 예외가 발생했다.");
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("socket을 종료하다가 예외가 발생했다.");
            }
        }
    }
}
