package Thread_Study03;

/**
 * 协作模型:生产者消费者实现方式一:管程法
 * 借助缓存区
 */
public class Cotest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->" + i + "个馒头");
            container.push(new Steamedbun(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 100; i++) {
            System.out.println("消费-->" + container.pop().getId() + "个馒头");

        }
    }
}

//缓冲区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10]; //存储容器
    int count = 0;    //计数器

    //存储 生产
    public synchronized void push(Steamedbun bun) {
        //何时生产 容器存在空间
        //不能生产 等待
        if (count == buns.length) {
            try {
                this.wait();    //线程阻塞 生产者通知消费 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        buns[count] = bun;
        count++;
        //存在数据,可以通知对方消费了
        this.notifyAll();
    }

    public synchronized Steamedbun pop() {
        //何时消费 容器中是否存在数据
        //没有数据 等待
        //有数据 可以消费
        if (count == 0) {
            try {
                this.wait();    //线程阻塞 生产者通知消费 解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun = buns[count];
        //存在空间了,可以唤醒对方生产了
        this.notifyAll();
        return bun;
    }
    //获取 消费
}

//馒头
class Steamedbun {
    private int id;

    public Steamedbun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
