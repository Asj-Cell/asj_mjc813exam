package chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClientWrite implements Runnable{
    private final Client client;
    private final DataOutputStream output;
    private boolean refit = false;

    public ClientWrite(DataOutputStream output,Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            nameInit(scanner);
            String word=":";
            while (true) {
                 word = scanner.nextLine();
                if (word.startsWith("/change|")) {
                    output.writeUTF(word);
                } else if (word.equals("/users")) {
                    output.writeUTF(word);
                } else if (word.equals("/exit")) {
                    output.writeUTF(word);
                    System.out.println("접속을 종료합니다.");
                    break;
                } else{
                    output.writeUTF("/message|" + word);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            client.close();
        }
    }

    private void nameInit(Scanner scanner) throws IOException {
        System.out.println("채팅방을 입장하기 전에 이름을 입력해주세요.");
        String name = scanner.nextLine();
        output.writeUTF("/join|"+name);
    }

    public synchronized void close() throws IOException {
        if (refit) {
            return;
        }
        client.close();
        refit = true;

    }
}
