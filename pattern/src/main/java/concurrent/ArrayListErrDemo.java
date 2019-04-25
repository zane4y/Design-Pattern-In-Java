package concurrent;

import java.util.ArrayList;

/**
 * ArrayList 线程不安全的例子
 *
 * @author luzy
 * viva la vida
 **/
public class ArrayListErrDemo {

    private static ArrayList<Integer> l = new ArrayList<>();

    public static void main(String[] args) {

        Runnable r = () -> {
            int i = 30000;
            do {
                l.add(i);
                i--;
            } while (i > 0);
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        System.out.println("Size is " + l.size());
    }
}
