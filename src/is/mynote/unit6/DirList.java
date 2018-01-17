package is.mynote.unit6;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author neal
 */
public class DirList extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file);
        return FileVisitResult.CONTINUE;
    }
}

class DirTreeList {
    public static void main(String[] args) {
        String dirName = "";
        System.out.println("Directory tree starting with " + dirName + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirName), new DirList());
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
        }
    }
}