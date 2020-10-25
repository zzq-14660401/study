package Thread_Study;

/**
 * 创建线程方式一
 * 1.创建:继承Thread+重写run
 * 2.启动:调用子类对象+start
 */
public class StartThread extends Thread {
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        //调用子类对象
        StartThread st = new StartThread();
        //启动
        st.start();
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边coding");
        }
    }
}

