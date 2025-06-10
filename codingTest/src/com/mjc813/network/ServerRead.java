package com.mjc813.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerRead implements Runnable {

    private final Socket sck;

    public ServerRead(Socket socket) {
        this.sck = socket;
    }

    @Override
    public void run() {
        try (InputStream is = sck.getInputStream()) {
            System.out.println("데이터 수신 시작: " + sck.getInetAddress().getHostAddress());
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                String str = new String(buffer, 0, bytesRead, "UTF-8");


                System.out.println("[상대] " + str);

                if (isClosed(str)) {
                    System.out.println("클라이언트 " + sck.getInetAddress().getHostAddress() + "로부터 종료 메시지 수신.");
                    break;
                }
            }

            System.out.println("클라이언트 " + sck.getInetAddress().getHostAddress() + "와의 연결이 정상적으로 종료되었습니다.");

        } catch (SocketException e) {
            System.out.println("클라이언트 " + sck.getInetAddress().getHostAddress() + "와의 연결이 끊어졌습니다: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("클라이언트 " + sck.getInetAddress().getHostAddress() + "와 통신 중 오류 발생: " + e.getMessage());
        } finally {
            if (sck != null && !sck.isClosed()) {
                try {
                    sck.close();
                    System.out.println("클라이언트 소켓을 닫았습니다: " + sck.getInetAddress().getHostAddress());
                } catch (IOException closeEx) {
                    System.err.println("클라이언트 소켓을 닫는 중 오류 발생: " + closeEx.getMessage());
                }
            }
        }
    }

    private static boolean isClosed(String str) {
        return str.trim().equals("exit!@#$app");
    }
}