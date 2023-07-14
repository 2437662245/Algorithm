package singleton;

/**
 * @author: joe
 * @dateTime: 2023/3/15 22:00
 * @description: 基于volatile + synchronized实现
 * @version: 1.0
 */
public class LazySingleton1 {
    public static volatile LazySingleton1 instance;

    public LazySingleton1 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton1.class) {
                if (instance == null) {
                    instance = new LazySingleton1();
                }
            }
        }
        return instance;
    }
}
