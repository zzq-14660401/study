package Thread_Study03;

/**
 * 线程安全:在并发时保证数据的正确性 效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynBlockTest01 {
    public static void main(String[] args) {
        SynWeb12306 web = new SynWeb12306();
        new Thread(web, "张三").start();
        new Thread(web, "李四").start();
        new Thread(web, "王五").start();

    }
}

class SynWeb12306 implements Runnable {
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test5();
        }
    }

    //线程安全:尽可能锁定合理的范围(不是指代码,指数据的完整性)
    //double checking
    public void test5() {
        if (ticketNums <= 0) {  //考虑没票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {  //考虑最后一张票的情况
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

    //线程不安全,范围太小锁不住
    public void test4() {

        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);

    }

    //线程不安全,锁定对象错误,ticketNums对象会变
    public void test3() {
        synchronized ((Integer) ticketNums) {
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

    //线程安全,范围太大-->效率低下
    public void test2() {
        synchronized (this) {
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

    //同步方法
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