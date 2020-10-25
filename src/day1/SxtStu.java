package day1;

public class SxtStu {
    //属性(成员变量)
    int ID;
    String sname;
    int age;

    //方法
    void study() {
        System.out.println("我正在学习!");
    }

    //构造方法(方法名和类名保持一致)
    SxtStu() {

    }

    public static void main(String[] args) {
        SxtStu s1 = new SxtStu();
        System.out.println(s1.ID);
        System.out.println(s1.sname);
        s1.ID = 1001;
        s1.sname = "张三";
        System.out.println(s1.ID);
        System.out.println(s1.sname);
        s1.study();
        System.out.println("==========");

    }
}
