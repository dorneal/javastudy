package is.mynote.unit13;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Neal
 */
public class BlockQueueTest {
    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(3);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread().getName() + " 来存");
                        queue.put(1);
                        System.out.println(Thread.currentThread().getName() +
                                "当前队列有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName() + " 来取");
                    queue.take();
                    System.out.println(Thread.currentThread().getName() +
                            "队列当前有" + queue.size() + "个数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
