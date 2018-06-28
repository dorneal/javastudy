package is.mynote.unit11;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class CompletionTest {
    public static void main(String[] args) {
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        CompletionService<String> service2 = new ExecutorCompletionService<>(service1);
        for (int i = 0; i < 10; i++) {
            service2.submit(() -> LocalTime.now().toString());
        }
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(service2.take().get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service1.shutdown();
    }
}
