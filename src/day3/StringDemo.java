package day3;

public class StringDemo {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        getInt(-1);
        long end = System.currentTimeMillis();

    }

    public static int getInt(Integer age) throws Exception {
        if (age<0){
            throw new Exception("age 不能小于 0");
        }
        System.out.println(age);
        return age;
    }
}
