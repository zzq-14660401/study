package Thread_Study02;

/**
 * 守护线程:是为用户线程服务的,JVM停止不用等待守护线程执行完毕
 * 默认:用户线程;JVM等待用户线程执行完毕才会停止
 */
public class Daemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        t.setDaemon(true);   //将用户线程调整为守护线程
        t.start();
        new Thread(you).start();
    }
}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 365 * 100; i++) {
            System.out.println("happy life...");
        }
        System.out.println("oooo...");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        for (; true; ) {
            System.out.println("bless you...");
        }
    }
}