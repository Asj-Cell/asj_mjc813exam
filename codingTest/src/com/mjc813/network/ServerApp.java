package com.mjc813.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;

public class ServerApp {
    private static ServerSocket ss = null;
    private final String allowedClientIp;

    public ServerApp(int port, String allowedIp) throws IOException {
        this.ss = new ServerSocket();
        this.ss.bind(new InetSocketAddress(port), 50);
        this.allowedClientIp = allowedIp;
        System.out.println("서버 소켓이 모든 로컬 IP 주소의 포트 " + port + "에 바인딩되었습니다.");
        System.out.println("오직 다음 IP 주소에서 오는 연결만 허용합니다: " + allowedClientIp);
    }

    public void init() {
        System.out.println("클라이언트 연결을 기다리는 중...");
        try {
            while (true) {
                Socket sck = null;
                try {
                    sck = this.ss.accept();
                    String clientIp = sck.getInetAddress().getHostAddress();

                    if (clientIp.equals(allowedClientIp)) {
                        System.out.println("클라이언트 연결 수락됨: " + clientIp);


                        ServerRead serverRead = new ServerRead(sck);
                        Thread readThread = new Thread(serverRead);
                        readThread.start();

                        ServerWrite serverWrite = new ServerWrite(sck);
                        Thread writeThread = new Thread(serverWrite);
                        writeThread.start();

                    } else {
                        System.out.println("연결 거부됨 (허용되지 않은 IP): " + clientIp);
                        sck.close();
                    }
                } catch (IOException e) {
                    System.out.println("클라이언트 연결 처리 중 오류 발생: " + e.getMessage());
                    if (sck != null && !sck.isClosed()) {
                        try {
                            sck.close();
                        } catch (IOException closeEx) {
                        }
                    }
                    break;
                }
            }
        } finally {
            if (ss != null && !ss.isClosed()) {
                try {
                    ss.close();
                    System.out.println("서버 소켓 닫힘.");
                } catch (IOException e) {
                    System.err.println("서버 소켓을 닫는 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("서버 시작...");
        int portNumber = 19999;
        // 실제 테스트 시, 이 IP는 클라이언트의 IP 주소로 변경해야 합니다.
        String sideIp = "10.11.83.67";

        try {
            ServerApp sa = new ServerApp(portNumber, sideIp);
            sa.init();
        } catch (IOException e) {
            System.err.println("서버 초기화 실패: " + e.getMessage());
        }
        System.out.println("서버 종료.");
    }

    public static void close(Socket socket) throws IOException {
        socket.close();
        ss.close();
    }
}