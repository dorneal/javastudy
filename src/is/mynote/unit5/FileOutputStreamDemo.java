package is.mynote.unit5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * FileOutputStream类的使用
 *
 * @author neal
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte[] buf = source.getBytes("UTF-8");
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        try {
            f0 = new FileOutputStream("file0.txt");
            f1 = new FileOutputStream("file1.txt");
            f2 = new FileOutputStream("file2.txt");

            // write to first file
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }

            f1.write(buf);

            f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.out.println("An I/O Occurred");
            e.printStackTrace();
        } finally {
            try {
                if (f0 != null) {
                    f0.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f1 != null) {
                    f1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
