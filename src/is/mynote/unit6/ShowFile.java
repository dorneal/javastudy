package is.mynote.unit6;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Display a text file using stream-based ,NIO code.
 * Requires JDK 7 or later.
 * <p>
 * To use this program,specify the name
 * of the file that you want to see.
 * For example, to see a file called TEXT.TXT.
 * use the following command line.
 *
 * @author neal
 */
public class ShowFile {
    public static void main(String[] args) {
        int i;
        //First, confirm that a filename has been specified.
        if (args.length != 1) {
            System.out.println("Usage:ShowFile filename");
            return;
        }

        //Open the file and obtain a stream linked to it.
        try (InputStream fin = Files.newInputStream(Paths.get(args[0]))) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
            e.printStackTrace();
        }
    }
}
