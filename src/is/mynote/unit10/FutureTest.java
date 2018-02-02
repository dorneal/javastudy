package is.mynote.unit10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * FutureTest测试
 *
 * @author Neal
 * @version 1.01 2018-02-01
 */
public class FutureTest {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter base directory(e.g /usr/local/jdk/src)");
            String directory = input.nextLine();
            System.out.print("Enter keyword (e.g volatile)");
            String keyword = input.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread thread = new Thread(task);
            thread.start();
            try {
                System.out.println(task.get() + " matching files.");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

class MatchCounter implements Callable<Integer> {
    private File file;
    private String keyword;

    MatchCounter(File file, String keyword) {
        this.file = file;
        this.keyword = keyword;
    }

    @Override
    public Integer call() {
        int count = 0;
        File[] files = file.listFiles();
        List<Future<Integer>> results = new ArrayList<>();

        for (File file1 : files) {
            if (file1.isDirectory()) {
                MatchCounter counter = new MatchCounter(file1, keyword);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file1)) {
                    count++;
                }
            }
        }
        for (Future<Integer> result : results) {
            try {
                count += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    private boolean search(File file) {
        try (Scanner input = new Scanner(file, "UTF-8")) {
            boolean found = false;
            while (!found && input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
                return found;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
