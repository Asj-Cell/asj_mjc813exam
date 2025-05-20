package chat.client;

import java.io.*;
import java.net.Socket;

public class CloseAll {

    public static void closeAll(Socket socket, InputStream input, OutputStream output) {
        try {
            if (input != null) {
                input.close();
            }
        } catch (IOException e) {
            new RuntimeException(e);
        }
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException e) {
            new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            new RuntimeException(e);
        }

    }
}
