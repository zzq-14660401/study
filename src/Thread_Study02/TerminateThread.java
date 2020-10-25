package Thread_Study02;

/**
 * 终止线程
 * 1.线程正常执行完毕
 * 2.外部干涉-->增加标识
 * 不要使用stop destroy
 */
public class TerminateThread implements Runnable {
    //加入标识,标记线程体是否可以运行
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        //关联标识 true->运行 false->停止
        while (flag) {
            System.out.println(name + "-->" + i++);
        }
    }

    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("张三");
        new Thread(tt).start();
        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                tt.terminate();
                System.out.println("tt game over");
            }
            System.out.println("main-->" + i);
        }
    }
}
