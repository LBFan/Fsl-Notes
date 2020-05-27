package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/18.
 */

public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "hello, world";
        outputStream.write(s.getBytes());
        outputStream.close();
    }
}

