package is.mynote.unit4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易服务器
 *
 * @author neal
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7896);
            Socket socket = serverSocket.accept();
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            while (bis.read() != 0) {
                System.out.print(bis.read());
            }
            //TODO 将值读取到，并写入
            byte[] bytes = new byte[1024 * 4];
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            // 假装写入
            bos.write(33);
            bos.flush();
            bos.close();
            bis.close();
        } catch (IOException e) {
            System.out.println("IO异常");
        }
    }
}
