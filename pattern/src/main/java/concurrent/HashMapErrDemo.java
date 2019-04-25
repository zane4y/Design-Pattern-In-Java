package concurrent;

import java.util.HashMap;

/**
 * HashMap线程不安全的例子
 * @author luzy
 * viva la vida
 **/
public class HashMapErrDemo {

    public static class Key {
        int val;

        Key(int val) {
            this.val = val;
        }

        @Override
        public int hashCode() {
            return val % 9;
        }
    }

    private static HashMap<Key, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Runnable r = () -> {
            int i = 50000;
            do {
                map.put(new Key(i), i);
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

        System.out.println("Size is " + map.size());
    }
}
