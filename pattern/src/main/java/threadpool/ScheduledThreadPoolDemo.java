package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author luzy
 * viva la vida
 **/
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newScheduledThreadPool(4);

        es = Executors.newSingleThreadExecutor();

        es.shutdown();
    }
}
