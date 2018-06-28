package is.mynote.unit11;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator
 */
public class TimerTest {
    private static int count = 0;

    private static class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            count = (count + 1) % 2;
            System.out.println("booming");
            new Timer().schedule(new MyTimerTask(), 2000L + 2000L * count);
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new MyTimerTask(), 2000L, 2000L);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
