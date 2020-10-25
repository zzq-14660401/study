package day7;

public class Test01 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        int[] arr2 = {20, 30, 40};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 2 + 1;
            System.out.println(arr1[i]);
        }
    }
}
