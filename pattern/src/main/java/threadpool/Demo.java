package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            es.submit(new MyRunnable(i));
        }

        es.shutdown();
    }

    public static class MyRunnable implements Runnable {
        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("This is no." + i);
                Thread.sleep(1L);
            } catch (Exception e) {
                // Hi...
            }
        }
    }
}
