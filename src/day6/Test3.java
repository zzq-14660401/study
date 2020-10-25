package day6;

public class Test3 {
    public void show() {
        class Inner3 {
            public void fun() {
                System.out.println("helloWorld");
            }
        }
        new Inner3().fun();
    }

    public static void main(String[] args) {
        new Test3().show();
    }
}
