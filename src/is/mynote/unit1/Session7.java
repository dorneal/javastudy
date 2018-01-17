package is.mynote.unit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程回显（echo）服务器
 *
 * @author neal
 */
public class Session7 {
    private static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("服务器已启动");
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandle(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandle implements Runnable {
        private Socket client;

        ClientHandle(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter pw = new PrintWriter(client.getOutputStream())) {
                String msg = br.readLine();
                System.out.println("收到" + client.getInetAddress() + "发送的：" + msg);
                pw.println(msg);
                pw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
