package Thread_Study03;

public class UnsafeTest01 {
    public static void main(String[] args) {
        UnsafeWeb12306 web = new UnsafeWeb12306();
        new Thread(web, "张三").start();
        new Thread(web, "李四").start();
        new Thread(web, "王五").start();

    }
}

class UnsafeWeb12306 implements Runnable {
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    public void test() {
        if (ticketNums < 0) {
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