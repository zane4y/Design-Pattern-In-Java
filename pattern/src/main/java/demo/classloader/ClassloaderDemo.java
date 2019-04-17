package demo.classloader;

/**
 * @author luzy
 * viva la vida
 **/
public class ClassloaderDemo {

    public static class SuperC {
        public int a;
        public static int sa = 1;
        static {
            System.out.println("这里进行SuperC的静态构造方法");
        }
        {
            System.out.println("这里进行SuperC的普通构造方法");
        }
    }

    public static class SubC extends SuperC {
        public int b;
        public static int sb = 2;
        static {
            System.out.println("我是SubC，我的父类是SuperC");
        }
        {
            System.out.println("这里进行SubC的普通构造方法");
        }
    }

    public static class Guison extends SubC {
        public int c;
        public static int sc = 3;
        static {
            System.out.println("我是Guison，我的父类是SubC");
        }
        {
            System.out.println("这里进行Guison的普通构造方法");
        }
        public static void pp() {
            System.out.println("调用Guison的static方法");
        }
    }

    // 1. 遇到new、getstatic、putstatic、invokestatic四条指令时，如果类没有初始化，那么触发初始化
    // 2. 反射调用时，需要触发初始化
    // 3. 调用一个类时，如果父类没有进行初始化，那么触发父类的初始化
    // 4. 用户指定的主类在启动时需要初始化（例如随便写个来玩时的main函数）
    // 5. 动态语言支持是，MethodHandle对象解析结果为某些句柄时，需要进行初始化
    public static void main(String[] args) {
        // 挑选想要的场景实验
        scene1_1();
    }

    private static void scene1_1() {
        System.out.println("-------> 这里触发new");
        SuperC c1 = new Guison();
        System.out.println("End~~ ");
    }

    private static void scene1_2() {
        System.out.println("-------> 这里触发getstatic");
        System.out.println(Guison.sc);
        System.out.println("End~~ ");
    }

    private static void scene1_3() {
        System.out.println("-------> 这里触发putstatic");
        Guison.sc = 4;
        System.out.println("End~~ ");
    }

    private static void scene1_4() {
        System.out.println("-------> 这里触发invokestatic");
        Guison.pp();
        System.out.println("End~~ ");
    }

    private static void scene2() {
        System.out.println("-------> 这里执行反射调用");
        try {
            Class c = Class.forName("demo.ClassloaderDemo$Guison");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
