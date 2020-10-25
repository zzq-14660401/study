package day1;

public class Test3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        while (a < 100) {
            System.out.println(a);
            System.out.println(b);
            a = a + b;
            b = b + a;

        }
    }
}
