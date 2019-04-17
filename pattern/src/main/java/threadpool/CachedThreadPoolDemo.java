package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luzy
 * viva la vida
 **/
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            try {
                es.submit(() -> {
                    try {
                        // Thread sleep randomly for 1 to 5 second
                        int sleepTime = (int) (Math.random() * 5) + 1;
                        Thread.sleep(sleepTime);
                        // print
                        System.out.println("i'm " + Thread.currentThread().getId() + ", i will sleep " + sleepTime);
                    } catch (Exception e) {
                        System.out.println("died");
                    }
                });
                Thread.sleep(1L);
            } catch (Exception e) {
                // FUCK
            }
        }
        es.shutdown();
    }
}
