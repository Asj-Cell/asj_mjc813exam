package after0602.q0623.chat.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientWriter implements Runnable {

    private Client client;
    private DataOutputStream output;
    private boolean closed;
    private static final String DELIMITER = "\\|";
    private Scanner scanner = new Scanner(System.in);


    public ClientWriter(Client client, DataOutputStream output) {
        this.client = client;
        this.output = output;
    }

    @Override
    public void run() {

        try {
            String userName = getUserName(scanner);
            output.writeUTF(userName);
            while (true) {

                String sendMessage = scanner.nextLine();
                if (sendMessage.equals("/exit")) {
                    output.writeUTF(sendMessage);
                    break;
                }

                if (sendMessage.isEmpty()) {
                    continue;
                }

                if (sendMessage.startsWith("/")) {
                    output.writeUTF(sendMessage);
                } else {
                    output.writeUTF("/message" + DELIMITER + sendMessage);
                }

            }

        } catch (IOException e) {
            System.out.println("client write 중 문제발생");
        } catch(NoSuchElementException e){
            System.out.println("scanner 종료중 예외발생 "+e.toString());
        }
        finally {
            System.out.println("client 자원을 종료합니다.");
            client.close();
        }


    }

    private static String getUserName(Scanner scanner) {
        String userName = null;
        do {
            System.out.println("-채팅을 이용할 회원의 이름을 입력해주세요-");
            userName = scanner.nextLine();
        } while (userName == null);
        return userName;
    }


    public synchronized void close() {
        if (closed) {
            return;
        }
        try {
            closed = true;
            System.out.println("ClientWriter 종료");
            System.in.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("ClientWriter 종료중 예외 발생"+e.toString());
        }
    }
}
