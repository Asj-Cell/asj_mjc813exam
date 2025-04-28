package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ServerHandler implements Runnable {

    private final Socket socket;


    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void process() throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, UTF_8);) {
            String readProcess = processRead(reader);
            System.out.println(readProcess);

            if (readProcess.startsWith("GET /site1")) {
                site1(writer);
            } else if (readProcess.startsWith("GET /site2")) {
                site2(writer);
            } else if (readProcess.startsWith("GET /search")) {
                search(writer,readProcess);
            } else if (readProcess.startsWith("GET / ")) {
                home(writer);
            } else {
                notFound(writer);
            }



        }

    }

    private void home(PrintWriter writer) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Home</h1>");
        sb.append("<ul>");
        sb.append("<li><a href=/site1>site1</a></li>");
        sb.append("<li><a href=/site2>site2</a></li>");
        sb.append("<li><a href=/search?q=hello>search</a></li>");
        sb.append("</ul>");
        String comment = sb.toString();
        int length = comment.getBytes(UTF_8).length;
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println("Content-Length: " + length);
        writer.println();
        writer.println(comment);
        writer.flush();
    }
    private void notFound(PrintWriter writer) {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>404 Not Found 지정한 경로를 찾을 수 없습니다.</h1>");
        writer.flush();
    }

    private void search(PrintWriter writer ,String requestString) {
        int startIndex = requestString.indexOf("q=");
        int endIndex = requestString.indexOf(" ",startIndex + 2);
        String query = requestString.substring(startIndex+2, endIndex);
        String newQuery = URLDecoder.decode(query);


        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Search</h1>");
        writer.println("<ul>");
        writer.println("<li> search: "+query+"</li>");
        writer.println("<li> search: "+newQuery+"</li>");
        writer.println("</ul>");
        writer.flush();

    }

    private void site2(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Site2</h1>");
        writer.flush();

    }

    private void site1(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=UTF-8");
        writer.println();
        writer.println("<h1>Site1</h1>");
        writer.flush();

    }

    private String processRead(BufferedReader reader) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }

            sb.append(line).append("\n");
        }
        return sb.toString();
    }

}
