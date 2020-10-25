package day6;

public class Test2 {
    public void test(A a) {
        a.run();
    }

    public static void main(String[] args) {
        Test2 tai = new Test2();
        tai.test(new A() {
            @Override
            public void run() {
                System.out.println("Test.run111");
            }
        });
        tai.test(new A() {
            @Override
            public void run() {
                System.out.println("test.run222");
            }
        });
    }

}

class AA implements A {

    @Override
    public void run() {
        System.out.println("AA.run");
    }
}

interface A {
    void run();
}
