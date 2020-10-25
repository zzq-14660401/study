package Thread_Study03;

public class SynTest02 {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");
        SafeDrawing you = new SafeDrawing(account, 80, "you");
        SafeDrawing wife = new SafeDrawing(account, 90, "ta");
        you.start();
        wife.start();

    }
}

//模拟取款
class SafeDrawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public SafeDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    public synchronized void test() {
        if (account.money - drawingMoney < 0) {
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->账户余额为:" + account.money);
        System.out.println(this.getName() + "-->口袋的钱为:" + packetTotal);
    }
}

