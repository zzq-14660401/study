package Thread_Study03;

public class SynBlockTest02 {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");
        SynDrawing you = new SynDrawing(account, 80, "you");
        SynDrawing wife = new SynDrawing(account, 90, "ta");
        you.start();
        wife.start();

    }
}

//模拟取款
class SynDrawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public SynDrawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    public void test() {
        if (account.money<=0){
            return;
        }
        synchronized (account) {
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
}

