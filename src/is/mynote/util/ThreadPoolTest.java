package is.mynote.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池的使用
 *
 * @author neal
 */
public class ThreadPoolTest {
    private static Lock lock = new ReentrantLock();
    private static Condition subThreadCondition = lock.newCondition();
    private static boolean bBhouldSubThread = false;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(() -> {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                try {
                    if (!bBhouldSubThread) {
                        subThreadCondition.await();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " ,j = " + j);
                    }
                    bBhouldSubThread = false;
                    subThreadCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        threadPool.shutdown();
        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                if (bBhouldSubThread) {
                    subThreadCondition.await();
                }
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + ",j=" + j);
                }
                bBhouldSubThread = true;
                subThreadCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
