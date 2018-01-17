package is.mynote.unit6;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * MappedChannelRead
 *
 * @author neal
 */
public class MappedChannelRead {
    public static void main(String[] args) {
        // Obtain a channel to a file within a try-with-resource block
        try (FileChannel fileChannel =
                     (FileChannel) Files.newByteChannel(Paths.get("file1.txt"))) {
            // Get the size of the file
            long fSize = fileChannel.size();

            //Now,map the file into a buffer.
            MappedByteBuffer mappedByteBuffer =
                    fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            // Read and display bytes from buffer.
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O ERROR " + e);
            e.printStackTrace();
        }
    }
}
