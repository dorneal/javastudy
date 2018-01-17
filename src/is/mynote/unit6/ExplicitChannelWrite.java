package is.mynote.unit6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * NIO.2系统的写入使用
 *
 * @author neal
 */
public class ExplicitChannelWrite {
    public static void main(String[] args) {
        // Obtain a channel to a file within a try-with-resource;
        try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("file0.txt")
                , StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // Create a buffer.
            ByteBuffer buffer = ByteBuffer.allocate(26);

            //write some bytes to the buffer.
            for (int i = 0; i < 26; i++) {
                buffer.put((byte) ('A' + i));
            }

            // Reset the buffer so that it can be written.
            buffer.rewind();

            //write the buffer to the output file
            channel.write(buffer);
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
            e.printStackTrace();
        }
    }
}
