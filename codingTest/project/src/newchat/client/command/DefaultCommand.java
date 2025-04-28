package newchat.client.command;

import newchat.client.server.Session;
import newchat.client.server.SessionManager;

import java.io.IOException;

public class DefaultCommand implements Command{

    @Override
    public void execute(String[] split, Session session) throws IOException {
        session.toSend("잘못된 형식 또는 없는 문법의 사용입니다.");
    }
}
