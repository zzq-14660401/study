package day7;

import java.util.Arrays;

public class test04 {
    public static void main(String[] args) {
        int[] a={1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("该元素的索引:"+Arrays.binarySearch(a,12));
        Arrays.fill(a,2,4,100);
        System.out.println(Arrays.toString(a));
    }
}
