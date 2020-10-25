package com.company;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7};
        int num = 4;
        print(arr,num);
    }

    public static void print(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                System.out.println(arr[i] + "大于" + num);
            } else {
                System.out.println(arr[i] + "小于" + num);
            }
        }
    }
}
