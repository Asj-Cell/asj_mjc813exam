package after0602.q0623.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SimpleClinet {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        output.writeUTF("Hi ");
        String readMessage = input.readUTF();
        System.out.println(readMessage);
    }
}
