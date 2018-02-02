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
    /**
     * 锁对象，常规锁（无参构造），公平锁(有参构造)性能大打折扣（偏爱线程等待时间长的）。
     */
    private static Lock lock = new ReentrantLock();
    /**
     * 条件对象或者条件变量
     */
    private static Condition subThreadCondition = lock.newCondition();
    private static boolean bBhouldSubThread = false;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(() -> {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                try {
                    //小技巧，使用while而不是if判断，以防止假唤醒
                    //信号，条件让出
                    while (!bBhouldSubThread) {
                        subThreadCondition.await();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " ,j = " + j);
                    }
                    bBhouldSubThread = false;
                    //释放所有，怕释放单独线程依然不满足条件，则会造成死锁
                    subThreadCondition.signalAll();
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
                //小技巧，使用while而不是if判断，以防止假唤醒
                while (bBhouldSubThread) {
                    subThreadCondition.await();
                }
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + ",j=" + j);
                }
                bBhouldSubThread = true;
                subThreadCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //使用finally释放锁
                lock.unlock();
            }
        }
    }
}
