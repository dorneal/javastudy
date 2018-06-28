package is.mynote.unit13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号灯的使用
 *
 * @author Neal
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    sp.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 " + Thread.currentThread().getName() + "进入，当前已有 " + (3 - sp.availablePermits()));
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 是放
                sp.release();
                System.out.println("线程 " + Thread.currentThread().getName() + "已离开，当前已有 " + (3 - sp.availablePermits()));
            };
            service.execute(runnable);
        }
        service.shutdown();
    }
}
