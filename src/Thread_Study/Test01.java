package Thread_Study;


public class Test01 {
    public static Object object = new Object();
    static Test01 test01 = new Test01();
    static Test01 test02 = new Test01();

    public static void main(String[] args) throws InterruptedException {
        new Thread(Test01::read).start();
        new Thread(Test01::write).start();
        Runnable task = Test01::write;
    }

    public static void read() {
        synchronized (test01) {
            System.out.println("读文件开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读文件完成");
        }
    }

    public static synchronized void write() {
        System.out.println("写文件开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("写文件完成");
    }
}
