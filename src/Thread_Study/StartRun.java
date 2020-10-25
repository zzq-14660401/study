package Thread_Study;

/**
 * 创建线程方式二
 * 1.创建:实现Runnable+重写run
 * 2.启动:调用实现类对象+Thread对象+start
 */
public class StartRun implements Runnable {
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        //调用实现类对象
        StartRun sr = new StartRun();
        //创建代理类对象
        Thread t=new Thread(sr);
        //启动
        t.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("一边coding");
        }
    }
}

