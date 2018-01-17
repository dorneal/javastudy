package is.mynote.unit6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Obtain information about a path and a file
 * Requires JDK 7 or later.
 *
 * @author neal
 */
public class PathDemo {
    public static void main(String[] args) {
        Path filePath = Paths.get("D:\\img\\3386\\338601");
        System.out.println("File name : " + filePath.getFileName());
        System.out.println("Path : " + filePath);
        System.out.println("Absolute Path: " + filePath.toAbsolutePath());
        System.out.println("Parent : " + filePath.getParent());

        if (Files.exists(filePath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exists");
        }

        try {
            if (Files.isHidden(filePath)) {
                System.out.println("File is Hidden");
            } else {
                System.out.println("File is not Hidden");
            }
        } catch (IOException e) {
            System.out.println("I/O Error :" + e);
            e.printStackTrace();
        }

        Files.isWritable(filePath);
        System.out.println("File is writable");
        Files.isReadable(filePath);
        System.out.println("File is readable");

        try {
            BasicFileAttributes attributes =
                    Files.readAttributes(filePath, BasicFileAttributes.class);

            if (attributes.isDirectory()) {
                System.out.println("The file is a directory");
            } else {
                System.out.println("The file is not a directory");
            }

            if (attributes.isRegularFile()) {
                System.out.println("The file is a normal file");
            } else {
                System.out.println("The file is not a normal file");
            }

            if (attributes.isSymbolicLink()) {
                System.out.println("The file is a symbolic link");
            } else {
                System.out.println("The file is not a symbolic link");
            }

            System.out.println("File last modified: " + attributes.lastModifiedTime());
            System.out.println("File size: " + attributes.size() + " Bytes");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
            e.printStackTrace();
        }
    }
}
