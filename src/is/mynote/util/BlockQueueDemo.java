package is.mynote.util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Neal
 */
public class BlockQueueDemo {
    final Lock lock = new ReentrantLock();
    final Condition notNull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] objects = new Object[100];
    /**
     * 队列元素总和，放入指针，拿出指针
     */
    int count, putptr, takeptr;

    private void put(Object object) throws InterruptedException {
        lock.lock();
        try {
            while (count == objects.length) {
                notNull.await();
            }
            objects[putptr] = object;
            if (++putptr == objects.length) {
                putptr = 0;
            }
            notEmpty.signalAll();
            ++count;
        } finally {
            lock.unlock();
        }
    }

    private Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = objects[takeptr];
            if (++takeptr == objects.length) {
                takeptr = 0;
            }
            --count;
            notNull.signalAll();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
