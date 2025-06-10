package com.mjc813.network3;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ClientHandlerManager {

    private final List<PrintWriter> clientWriters = new Vector<>();

    public void addClient(PrintWriter writer) {
        this.clientWriters.add(writer);
    }

    public void removeClient(PrintWriter writer) {
        this.clientWriters.remove(writer);
    }

    public void removeAllClient() {
        for (PrintWriter clientWriter : clientWriters) {
            removeClient(clientWriter);
        }
        clientWriters.clear();
    }

    public void sendMessage(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }
}