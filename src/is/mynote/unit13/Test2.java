package is.mynote.unit13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程直接的通信
 *
 * @author Neal
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Bussine bussine = new Bussine();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    bussine.sub2(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    bussine.sub3(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < 50; i++) {
            bussine.main(i);
        }
    }

    static class Bussine {
        private Lock lock = new ReentrantLock();
        private Condition c1 = lock.newCondition();
        private Condition c2 = lock.newCondition();
        private Condition c3 = lock.newCondition();
        private int shouldGo = 1;

        private void sub2(int i) throws InterruptedException {
            lock.lock();
            try {
                while (shouldGo != 2) {
                    c2.await();
                }
                for (int j = 0; j < 20; j++) {
                    System.out.println("sub2 " + i + " " + j);
                }
                shouldGo = 3;
                c3.signalAll();
            } finally {
                lock.unlock();
            }
        }

        private void sub3(int i) throws InterruptedException {
            lock.lock();
            try {
                while (shouldGo != 3) {
                    c3.await();
                }
                for (int j = 0; j < 30; j++) {
                    System.out.println("sub3 " + i + " " + j);
                }
                shouldGo = 1;
                c1.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public void main(int i) throws InterruptedException {
            lock.lock();
            try {
                while (shouldGo != 1) {
                    c1.await();
                }
                for (int j = 0; j < 10; j++) {
                    System.out.println("main " + i + " " + j);
                }
                shouldGo = 2;
                c2.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
