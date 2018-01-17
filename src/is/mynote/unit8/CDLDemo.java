package is.mynote.unit8;

import java.util.concurrent.CountDownLatch;

/**
 * @author neal
 */
public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Starting ");
        new MyThread(cdl);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}

class MyThread implements Runnable {
    private CountDownLatch latch;

    MyThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}