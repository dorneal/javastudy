package is.mynote.util;


/**
 * A线程输出10次，B线程输出100次，再A线程输出10次，
 * 再B线程线程输入100次，如此循环50次
 *
 * @author Neal
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class TraditionalThreadTest {
    private static class SugThread {
        /**
         * 信号
         */
        private boolean isFree = false;

        private synchronized void sub(int i) {
            while (isFree) {
                try {
                    // 主等待 让出锁
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread " + j + " is " + i);
            }
            isFree = true;
            // 子 释放锁
            this.notify();
        }

        private synchronized void main(int i) {
            while (!isFree) {
                try {
                    // 子等待 让出锁
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("main thread " + j + " is " + i);
            }
            isFree = false;
            // 主 释放锁
            this.notify();
        }
    }

    public static void main(String[] args) {
        SugThread sugThread = new SugThread();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                sugThread.sub(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                sugThread.main(i);
            }
        }).start();
    }
}
