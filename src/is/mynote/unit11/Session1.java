package is.mynote.unit11;


import is.mynote.unit1.Session14;

/**
 * @author Administrator
 */
public class Session1 {
    private static int count = 0;

    public static void main(String[] args) {
        // 双线程加1
        for (int i = 0; i < 1; i++) {
            new Thread(new Session1().new Inc()).start();
            new Thread(new Session1().new Dec()).start();
        }
//        System.out.println(count);
    }

    private static void add() {
        synchronized (Session1.class) {
            count++;
        }
        System.out.println(Thread.currentThread() + " add " + count);
    }

    private static void del() {
        synchronized (Session1.class) {
            count--;
        }
        System.out.println(Thread.currentThread() + " del " + count);
    }

    class Inc implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                add();
            }
        }
    }

    class Dec implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                del();
            }
        }
    }
}
