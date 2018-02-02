package is.mynote.unit10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * Fork/Join框架
 *
 * @author Neal
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int size = 1000000;
        double[] numbers = new double[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

class Counter extends RecursiveTask<Integer> {
    private static final int THREHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    Counter(double[] values, int from, int to, DoublePredicate filter) {
        this.filter = filter;
        this.from = from;
        this.to = to;
        this.values = values;
    }

    @Override
    protected Integer compute() {
        if (to - from < THREHOLD) {
            int count = 0;
            for (int i = from; i < to; i++) {
                if (filter.test(values[i])) {
                    count++;
                }
            }
            return count;
        } else {
            int mid = (from + to) / 2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}

