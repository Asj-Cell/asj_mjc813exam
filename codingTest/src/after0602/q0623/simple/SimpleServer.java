package after0602.q0623.simple;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // 여기서 tcp 연결이됨
        Socket socket = serverSocket.accept();

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String readMessage = input.readUTF();
        System.out.println(readMessage);
        output.writeUTF(readMessage+" Hi");
    }
}
