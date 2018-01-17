package is.mynote.unit8;

import java.io.*;
import java.net.Socket;

/**
 * @author neal
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6789);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info;
        while ((info = br.readLine()) != null) {
            System.out.println("我是客户端，服务器说：" + info);
        }
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
}
