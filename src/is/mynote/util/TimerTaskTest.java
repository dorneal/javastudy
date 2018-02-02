package is.mynote.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器的使用
 *
 * @author Neal
 */
public class TimerTaskTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("boom!!!!");
            }
            // delay:起始时间，period:间隔时间
        }, 2000, 2000);
    }
}
