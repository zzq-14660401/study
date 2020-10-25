package day;

public class Test1 {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        long d2 = System.currentTimeMillis();
        long result = factorial(20);
        System.out.println("阶乘的结果:" + result);
        System.out.println("递归耗时:" + (d2 - d1));
    }

    static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
