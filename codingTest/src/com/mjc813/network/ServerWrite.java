package com.mjc813.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ServerWrite implements Runnable {

    private final Socket sck;

    public ServerWrite(Socket socket) {
        this.sck = socket;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);

        try (OutputStream os = sck.getOutputStream()) {

            while (!sck.isClosed()) {
                if (!input.hasNextLine()) {
                    break;
                }
                String s = input.nextLine();

                if (s.trim().isEmpty()) {
                    continue;
                }

                os.write((s + "\n").getBytes(StandardCharsets.UTF_8));
                os.flush();

                System.out.println("[나] " + s);

                if ("exit".equalsIgnoreCase(s.trim())) {
                    System.out.println("서버에서 연결 종료를 시작합니다.");
                    break;
                }
            }
        } catch (SocketException e) {
            System.out.println("메시지를 보낼 수 없습니다. 소켓이 닫혔습니다.");
        } catch (IOException e) {
            System.err.println("클라이언트에게 메시지 전송 중 오류 발생: " + e.getMessage());
        } finally {

            try {
                ServerApp.close(sck);
            } catch (IOException e) {
            }

            System.out.println("쓰기 스레드를 종료합니다: " + sck.getInetAddress().getHostAddress());
        }
    }
}