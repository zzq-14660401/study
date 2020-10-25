package day7;

import java.util.Arrays;

public class Test07 {
    public static void main(String[] args) {
        int[] values = {3, 1, 5, 8, 4, 6, 7, 9, 0, 2};
        bubbleSort(values);
        System.out.println(Arrays.toString(values));
    }

    private static void bubbleSort(int[] values) {
        int temp;
        for (int i = 0; i < values.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
