package newchat.client.command;

import newchat.client.server.Session;

import java.io.IOException;

public interface Command {

    void execute(String[] split, Session session) throws IOException;
}
