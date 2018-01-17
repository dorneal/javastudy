package is.mynote.unit6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Display a directory.
 * Requires JDK7 or later.
 *
 * @author neal
 */
public class MyDir {
    public static void main(String[] args) {
        String dirName = "D:\\img\\3386\\338601\\";

        //Obtain and manage a directory stream within a try block.
        try (DirectoryStream<Path> directoryStream =
                     Files.newDirectoryStream(Paths.get(dirName))) {
            System.out.println("Directory of " + dirName);

            // Because DirectoryStream implements Iterable ,
            // We can use "foreach" loop to display the directory
            for (Path path : directoryStream) {
                BasicFileAttributes attributes =
                        Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.print("<DIR>");
                } else {
                    System.out.print("    ");
                }
                System.out.println(path.getName(1));
            }
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
            e.printStackTrace();
        }
    }
}
