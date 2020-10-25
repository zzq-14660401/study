package Thread_Study03;

public class UnsafeTest02 {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");
        Drawing you = new Drawing(account, 80, "you");
        Drawing wife = new Drawing(account, 90, "ta");
        you.start();
        wife.start();

    }
}


//模拟取款
class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int packetTotal;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
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

