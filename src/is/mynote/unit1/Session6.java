package is.mynote.unit1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Session6 {
    /**
     * NIO实现打印目录树
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Path initPath = Paths.get("c:\\Users");
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
