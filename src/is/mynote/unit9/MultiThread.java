package is.mynote.unit9;

/**
 * @author Neal
 */
public class MultiThread {
    public static void main(String[] args) {
        new Thread(new NewThread()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new NewThread2()).start();
    }
}

class NewThread implements Runnable {

    @Override
    public void run() {
        /*
        由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器,
        我们这里不能用this，因为在Thread2里面的this和这个Thread1的this不是指同
        一个对象。我们用MultiThread.class这个字节码对象，当前虚拟机里引用这个
        变量时，指向的都是同一个对象。
         */
        synchronized (MultiThread.class) {
            System.out.println("Enter thread1");
            System.out.println("thread1 is waiting");
            try {
                /*
                释放锁有两种方式，第一种方式是程序自然离开监视器范围，
                也就是离开了synchronized 关键字的管辖的代码范围，另一种
                方式就是在synchronized关键字关系代码内部调用监视器对象的
                wait方法，这里，使用wait方法释放锁
                 */
                MultiThread.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is going on...");
            System.out.println("thread1 is being over...");
        }
    }
}

class NewThread2 implements Runnable {

    @Override
    public void run() {
        synchronized (MultiThread.class) {
            System.out.println("Enter thread2");
            System.out.println("thread2 notify other thread on release " +
                    "wait status");
            /*
           由于notify方法并不释放锁，即使thread2调用下面的sleep方法休息10毫秒，
           但thread1仍然不会执行，因为thread2并没有释放锁，所以thread1无法得到锁
           需等到thread2自行离开监视器范围
             */
            MultiThread.class.notify();
            System.out.println("thread2 is sleeping ten millisecond....");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 is going on...");
            System.out.println("thread2 is being over...");
        }
    }
}
