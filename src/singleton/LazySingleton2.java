package singleton;

/**
 * @author: joe
 * @dateTime: 2023/3/15 22:09
 * @description: TODO
 * @version: 1.0
 * JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。在
 * 执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化。
 */
public class LazySingleton2 {

    private static class InstanceHolder {
        public static LazySingleton2 instance = new LazySingleton2();
    }

    public static LazySingleton2 getInstance() {
        return InstanceHolder.instance;  // 这里InstanceHolder类被初始化
    }
}
