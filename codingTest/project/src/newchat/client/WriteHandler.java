package newchat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteHandler implements Runnable {

    private final DataOutputStream output;
    private final Client client;
    private boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            nameSetting(scanner);
            while (true) {
                String toSend = scanner.nextLine();
                if (toSend.isEmpty()) {
                    continue;
                }
                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message|"+toSend);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            client.close();
        }
    }

    private void nameSetting(Scanner scanner) throws IOException {
        System.out.println("-채팅에서 사용할 사용자 이름을 입력하세요-");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("공백을 제외한 사용자 이름을 입력하세요: ");
            name = scanner.nextLine();
        }
        output.writeUTF("/join|"+name);
    }

    public void close()   {
        if (closed) {
            return;
        }
        // write에 종료 조직 있다고 가정 있으면 자원 정리
        try {
            System.in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("WriteHandler 자원 종료");
        closed = true;

    }
}
