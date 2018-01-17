package is.mynote.unit4;

/**
 * @author neal
 */
public class ThreadTest {
    private int i;

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        Inc inc = threadTest.new Inc();
        Dec dec = threadTest.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread incThread = new Thread(inc);
            incThread.start();
            incThread = new Thread(dec);
            incThread.start();
        }
    }

    private synchronized void inc() {
        i++;
        System.out.println(Thread.currentThread().getName() + " ---inc--- " + i);
    }

    private synchronized void dec() {
        i--;
        System.out.println(Thread.currentThread().getName() + " ---dec--- " + i);
    }

    class Inc implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
