package is.mynote.unit1;


public class Session14 implements Runnable {
    public static void main(String[] args) {
        new Session14();
        // 获取主线程
        Thread t = Thread.currentThread();
        System.out.println("main thread " + t);
        t.setName("My MainThread");
        System.out.println("this is my " + t);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread is Interrupted");
        }
    }

    Thread thread;

    Session14() {
        // create a new ,second Thread
        thread = new Thread(this, "Demo thread");
        System.out.println("Child thread " + thread);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Child thread interrupted");
            }
        }
    }
}
