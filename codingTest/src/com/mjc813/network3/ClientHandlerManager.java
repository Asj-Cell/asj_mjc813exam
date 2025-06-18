package com.mjc813.network3;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ClientHandlerManager {

    private final List<PrintWriter> clientWriters = new Vector<>();
    private final List<Socket> clientSockets = new Vector<>();

    public void addClient(PrintWriter writer, Socket socket) {
        this.clientWriters.add(writer);
        this.clientSockets.add(socket);
    }

    public void removeClient(Socket socket) {
        this.clientSockets.remove(socket);
    }

    public void removeAllClient() {
        for (Socket clientSocket : clientSockets) {
            removeClient(clientSocket);
        }
        clientWriters.clear();
        clientSockets.clear();
    }

    public void sendMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }
}

