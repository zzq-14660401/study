package day5;

public class SuperMan implements Volant, HOnest {
    public void fly() {
        System.out.println("横着飞");
    }

    public void stop() {
        System.out.println("竖着飞");
    }

    public void helpOther() {
        System.out.println("哪里需要,飞哪里");
    }

    public static void main(String[] args) {
        SuperMan m1 = new SuperMan();
        m1.fly();
        m1.stop();
        m1.helpOther();
    }
}
