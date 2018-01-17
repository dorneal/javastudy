package is.mynote.unit6;

import java.io.IOException;
import java.nio.file.*;

/**
 * NIO.2系统实现
 *
 * @author neal
 */
public class NIOCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage:Copy from to");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            //Copy the file.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
            e.printStackTrace();
        }
    }
}
