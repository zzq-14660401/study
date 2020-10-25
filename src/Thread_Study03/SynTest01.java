package Thread_Study03;

/**
 * 线程安全:在并发时保证数据的正确性 效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynTest01 {
    public static void main(String[] args) {
        SafeWeb12306 web = new SafeWeb12306();
        new Thread(web, "张三").start();
        new Thread(web, "李四").start();
        new Thread(web, "王五").start();

    }
}

class SafeWeb12306 implements Runnable {
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    public synchronized void test() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}