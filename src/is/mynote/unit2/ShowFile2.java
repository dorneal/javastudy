package is.mynote.unit2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author neal
 */
public class ShowFile2 {
    public static void main(String[] args) {
        int i;
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
