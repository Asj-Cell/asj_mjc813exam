package after0602.q0609;

import java.net.InetSocketAddress;
import java.net.Socket;

public class CAppTest {
    private Socket sck = null;

    public CAppTest() {
        this.sck = new Socket();
    }

    public void init(String idAddr, int port) {
        InetSocketAddress sa = new InetSocketAddress(idAddr,port);
//        this.sck.connect();
    }

}
