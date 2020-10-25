package Thread_Study03;

public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(2, "sxt");
        new Psaaenger(c, "张三", 2).start();
        new Psaaenger(c, "李四", 1).start();
    }
}

//顾客
class Psaaenger extends Thread {
    int seats;

    public Psaaenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}

//影院
class Web12306 implements Runnable {
    int available;  //可用的位置
    String name;    //名称

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public void run() {
        Psaaenger p = (Psaaenger) Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag) {
            System.out.println("出票成功!" + Thread.currentThread().getName() + "-<位置为:" + p.seats);
        } else {
            System.out.println("出票失败!" + Thread.currentThread().getName() + "-<位置不够!");
        }
    }

    //购票
    public synchronized boolean bookTickets(int seats) {
        System.out.println("可用位置为:" + available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}
