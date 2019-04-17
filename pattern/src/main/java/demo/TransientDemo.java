package demo;

import java.io.*;

/**
 * @author luzy
 * viva la vida
 **/
public class TransientDemo implements Serializable {

    // private int a;
    private transient int a;

    public static void main(String[] args) {

        TransientDemo f = new TransientDemo();
        f.a = 2;

        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        byte[] results;

        // 将对象序列化
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(f);
            oos.close();
            results = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("非序列化的对象", e);
        }
        System.out.println(results.length);
        // 将对象反序列化
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(results);
            ObjectInputStream ois = new ObjectInputStream(bis);
            TransientDemo o = (TransientDemo) ois.readObject();
            // 打印出a的数值，如果没有序列化的话，反序列化根本就无法读取
            System.out.println(o.a);
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("非序列化的对象", e);
        }

    }
}
