package is.mynote.unit11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Administrator
 */
public class ThreadLocalTest {
    //    private static int data = 0;
    //    private static Map<Thread, Integer> map = new HashMap<>(16);
    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                local.set(data);
                new A().getA();
                new B().getB();
                local.remove();
            }).start();
        }
    }

    static class A {
        private void getA() {
            int data = local.get();
            System.out.println("getA() " + Thread.currentThread().getName() + " and data is " + data);
        }
    }

    static class B {
        private void getB() {
            int data = local.get();
            System.out.println("getB() " + Thread.currentThread().getName() + " and data is " + data);
        }
    }
}
