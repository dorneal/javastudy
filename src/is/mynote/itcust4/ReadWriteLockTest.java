package is.mynote.itcust4;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Neal
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        final Queue3 queue3 = new Queue3();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    queue3.get();
                }
            }).start();

            new Thread(() -> {
                while (true) {
                    queue3.put(random.nextInt(100000));
                }
            }).start();
        }
    }
}

class Queue3 {
    // 共享数据
    private Object data = null;
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ready to read data");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " read data:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void put(Object data) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ready to write");
            this.data = data;
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " write data:" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
