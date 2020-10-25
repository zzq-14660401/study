package Thread_Study04;

/**
 * 指令重排:代码之星顺序与预期不一致
 * 目的:提高性能
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            a = 0;
            flag = false;
            Thread t1 = new Thread(() -> {
                a = 1;
                flag = true;
                System.out.println("....");
            });
            Thread t2 = new Thread(() -> {
                if (flag) {
                    a *= 1;
                }
                if (a == 0) {
                    System.out.println("happen before" + a);
                }
            });
            t2.start();
            t1.start();
            t1.join();
            t2.join();
        }
    }
}
