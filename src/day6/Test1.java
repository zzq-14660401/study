package day6;

public class Test1 {
    public static void main(String[] args) {
        String str1 = new String("abcdefg");
        String str2 = "abcdefg";
        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1.equals(str2));
    }
}
