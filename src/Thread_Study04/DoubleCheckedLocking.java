package Thread_Study04;

/**
 * DCL单例模式:懒汉式套路基础上加入并发控制,保证在多线程环境下,对外存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供私有的静态属性-->存储对象的地址
 * 3.提供公共的静态方法-->获取属性
 */
public class DoubleCheckedLocking {
    //2.提供私有的静态属性
    private static volatile DoubleCheckedLocking instance;

    //1.构造器私有化
    private DoubleCheckedLocking() {

    }

    private static DoubleCheckedLocking getInstance1(long time) {

        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new DoubleCheckedLocking();
        }
        return instance;
    }

    //3.提供公共的静态方法
    private static DoubleCheckedLocking getInstance(long time) {
        if (null != instance) {
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(DoubleCheckedLocking.getInstance(500));
        });
        t1.start();
        System.out.println(DoubleCheckedLocking.getInstance(1000));
    }
}
