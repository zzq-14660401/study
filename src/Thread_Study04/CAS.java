package Thread_Study04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:比较并交换
 */
public class CAS {
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 0) {
                    System.out.println("抢完了.....");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢到了一件->还剩" + left);
            }).start();
        }
    }
}
