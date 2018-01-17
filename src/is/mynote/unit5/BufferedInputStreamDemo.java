package is.mynote.unit5;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * BufferedInputStream类的使用
 *
 * @author neal
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "This is a &copy; copyright symbol "
                + "but this is &copy; not.\n";
        byte[] buf = s.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(buf);

        int c;
        boolean marked = false;

        // Use try-with-resource to manager the file
        try (BufferedInputStream f = new BufferedInputStream(stream)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            // return index
                            f.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                    default:
                        if (!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error:" + e);
        }
    }
}
