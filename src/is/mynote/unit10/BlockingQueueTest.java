package is.mynote.unit10;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列Demo，程序在一个目录及它的所有子目录下搜索所有文件，打印出包含指定关键字的行
 *
 * @author Neal
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter base directory (e.g /opt/jdk1.8.0/src):");
            String directory = input.nextLine();
            System.out.print("Enter keyword (e.g volatile)");
            String keyword = input.nextLine();
            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            new Thread(enumerator).start();

            for (int i = 1; i < SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * Recursively enumerates all files in a given and its subdirectories.
     *
     * @param directory the directory in which to start
     */
    private static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        assert files != null : "文件夹不能为空！！！";
        for (File file : files) {
            if (file.isDirectory()) {
                enumerate(file);
            } else {
                queue.put(file);
            }
        }
    }

    /**
     * Searches a file for a given keyword and prints all matching lines.
     *
     * @param file    the file to search
     * @param keyword the keywords to search for
     */
    private static void search(File file, String keyword) {
        try (Scanner in = new Scanner(System.in)) {
            int lineNumber = 0;
            while (in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.format("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }
}
