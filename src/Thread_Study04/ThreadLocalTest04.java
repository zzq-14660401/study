package Thread_Study04;

/**
 * InheritableThreadLocal:继承分析上下文 环境的数据
 */
public class ThreadLocalTest04 {

    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(100);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }).start();
    }

}
