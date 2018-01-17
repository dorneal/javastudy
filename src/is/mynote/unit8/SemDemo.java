package is.mynote.unit8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * @author neal
 */
public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncThread(sem, "A");
        new DecThread(sem, "B");
        List<String> list = new ArrayList<>();
        list.iterator();
    }
}

/**
 * A shared resource.
 */
class Shared {
    static int count = 0;
}

/**
 * A thread of execution that increments count.
 */
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        this.name = n;
        this.sem = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting: " + name);

        try {
            //First,get a permit
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " release the permit.");
        sem.release();
    }
}

/**
 *
 */
class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        this.name = n;
        this.sem = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            //First,get a permit
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
            System.out.println(name + " release the permit.");
            sem.release();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}