package day5;

public class Test {
    public static void main(String[] args) {
        A a=new Test_A();
        a.moren();
    }
}
interface A{
    default void moren(){
        System.out.println("我是接口A中的默认方法");
    }
}
class Test_A implements A{
    public void moren(){
        System.out.println("Test_A.moren");
    }
}
