package is.mynote.unit11;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerTest2 {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(3)
                .scheduleAtFixedRate(() -> System.out.println("boom"),
                        2, 4,
                        TimeUnit.SECONDS);
    }
}
