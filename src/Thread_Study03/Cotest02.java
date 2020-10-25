package Thread_Study03;

/**
 * 协作模型:生产者消费者实现方式一:信号灯法
 * 借助标志位
 */
public class Cotest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("一二三");
            } else {
                this.tv.play("齐步走");
            }
        }
    }
}

//消费者 观众
class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//同一份资源 电视
class Tv {
    String voice;
    //信号灯
    //T 演员表演,观众等待
    //F 观众观看,演员等待
    boolean flag = true;

    //演员表演
    public synchronized void play(String voice) {
        //演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了:" + voice);
        this.voice = voice;
        this.notifyAll();
        this.flag = !this.flag;
    }

    //观众观看
    public synchronized void watch() {
        //观众等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了:" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}

