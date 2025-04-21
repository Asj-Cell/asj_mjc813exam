package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CloseAll {

    public static void closeAll(Socket socket, DataInputStream input, DataOutputStream output) {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
