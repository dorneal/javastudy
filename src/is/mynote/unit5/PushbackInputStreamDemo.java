package is.mynote.unit5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * PushbackInputSteam类的使用
 *
 * @author neal
 */
public class PushbackInputStreamDemo {
    public static void main(String[] args) {
        String s = "if (a == 4) a = 0;\n ";
        byte[] buf = s.getBytes();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(buf);
        int c;
        try (PushbackInputStream inputStream1 = new PushbackInputStream(inputStream)) {
            while ((c = inputStream1.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = inputStream1.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            inputStream1.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
