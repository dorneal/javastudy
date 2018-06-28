package is.mynote.unit13;


import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Neal
 */
public class Test {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean isAllow = false;

    public static void main(String[] args) {
//        ExecutorService service = new ThreadPoolExecutor(1,
//                50,
//                20,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue(20));
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(() -> {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                try {
                    while (!isAllow) {
                        condition.await();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " " + i + " " + j);
                    }
                    condition.signalAll();
                    isAllow = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        service.shutdown();
        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                while (isAllow) {
                    condition.await();
                }
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + i + " " + j);
                }
                condition.signalAll();
                isAllow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
