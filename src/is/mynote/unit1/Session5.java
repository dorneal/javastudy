package is.mynote.unit1;

import java.io.File;
import java.io.IOException;

/**
 * 打印目录
 *
 * @author Neal
 */
public class Session5 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users");
        for (File temp : f.listFiles()) {
            if (temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }
}
