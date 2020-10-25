package day1;

public class Test2 {
    public static void main(String[] args) {
        long d3=System.currentTimeMillis();
        int a=10;
        int result=1;
        while (a>1){
            result=result*a*(a-1);
            a=a-2;
        }
        long d4=System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("普通循环费时:%s%n",d4-d3);
    }
}
