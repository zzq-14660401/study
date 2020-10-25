package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 1, 5, 10, 4, 3};
        int[] expore = {1, 5};
        int[] newarr=getNewArr(arr,expore);
        for (int i = 0; i < newarr.length; i++) {
            System.out.println(newarr[i]);
        }
    }

    public static int findMax(int[] arr) {
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = 1000000;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findNum(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;

    }

    public static int maxAndMinSum(int[] arr) {
        int sum = findMax(arr) + findMin(arr);
        return sum;
    }

    public static int sumAndExpore(int[] arr, int[] expore) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (findNum(expore, arr[i]) != -1) {
                continue;
            }
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int[] getNewArr(int[] arr, int[] expore) {
        int[] newarr = new int[arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (findNum(expore, arr[i]) == -1) {
                newarr[counter] = arr[i];
                counter++;
            }
        }
        return newarr;
    }
}
