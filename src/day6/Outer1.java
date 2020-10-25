package day6;

public class Outer1 {
    private int age = 10;

    private void show() {
        System.out.println("要你好看!");
    }

    public class Inner1 {
        private int age = 20;
        private String name = "tom";

        public void showInner() {
            System.out.println("Inner.showInner");
            System.out.println(age);
            System.out.println(Outer1.this.age);
            show();
        }
    }

    public static void main(String[] args) {
        Outer1.Inner1 inn01 = new Outer1().new Inner1();
        inn01.showInner();
    }
}
