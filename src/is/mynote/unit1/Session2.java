package is.mynote.unit1;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池的使用，以及Callable的使用
 *
 * @author neal
 */
public class Session2 implements Callable {
    private int upperBounds;

    Session2(int upperBounds) {
        this.upperBounds = upperBounds;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i <= upperBounds; i++) {
            sum += i;
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new Session2((int) (Math.random() * 100))));
        }
        int sum = 0;
        for (Future<Integer> future : list) {
            sum += future.get();
        }
        System.out.println(sum);
    }
}
