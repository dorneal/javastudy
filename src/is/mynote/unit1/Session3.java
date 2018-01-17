package is.mynote.unit1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author neal
 * 实现文件拷贝
 */
public final class Session3 {
    /**
     * 工具类中的方法都是静态方法访问的，因此将构造器私有不允许创建对象
     */
    private Session3() {
        throw new AssertionError();
    }

    /**
     * IO文件拷贝
     *
     * @param source 原位置
     * @param target 指定位置
     * @throws IOException IOException
     */
    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while ((bytesToRead = in.read()) == -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    /**
     * NIO实现文件拷贝
     *
     * @param source 原位置
     * @param target 现位置
     * @throws IOException IOException
     */
    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChanel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChanel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
