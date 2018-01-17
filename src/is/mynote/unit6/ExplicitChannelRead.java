package is.mynote.unit6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NIO.2系统的使用
 *
 * @author neal
 */
public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath;
        // First,obtain a path to the file.
        try {
            filepath = Paths.get("file0.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
            return;
        }

        //Next,obtain a channel to that file within a try-with-resource block.
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {
            // Allocate a buffer.
            ByteBuffer mBuf = ByteBuffer.allocate(128);
            do {
                // Read a buffer.
                count = fChan.read(mBuf);

                //Stop when end of file is reached.
                if (count != -1) {
                    //Rewind the buffer so that it can be read.
                    mBuf.rewind();

                    //Read bytes from the buffer and show
                    // them on the screen as characters
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O ERROR" + e);
            e.printStackTrace();
        }
    }
}
