package is.mynote.unit6;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 另一种写法
 *
 * @author neal
 */
public class MappedChannelWrite {
    public static void main(String[] args) {
        //Obtain a channel to a file within a try-with-resource block.
        try (FileChannel channel = (FileChannel) Files
                .newByteChannel(Paths.get("file2.txt")
                        , StandardOpenOption.WRITE
                        , StandardOpenOption.READ
                        , StandardOpenOption.CREATE)) {
            // Then ,map the file into a buffer.
            MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            // Write some bytes to the buffer.
            for (int i = 0; i < 26; i++) {
                byteBuffer.put((byte) ('A' + i));
            }
        } catch (IOException e) {
            System.out.println("I/O Error " + e);
            e.printStackTrace();
        }
    }
}
