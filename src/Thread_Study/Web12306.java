package Thread_Study;

public class Web12306 implements Runnable {
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web, "张三").start();
        new Thread(web, "李四").start();
        new Thread(web, "王五").start();
    }
}
