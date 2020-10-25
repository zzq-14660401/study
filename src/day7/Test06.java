package day7;

public class Test06 {
    public static void main(String[] args) {
        Object[] emp0 = {1001, "高小一", 18, "程序员", "2019-9-9"};
        Object[] emp1 = {1002, "高小二", 19, "程序员", "2019-10-9"};
        Object[] emp2 = {1003, "高小三", 20, "程序员", "2019-11-9"};
        Object[][] emps = new Object[3][];
        emps[0] = emp0;
        emps[1] = emp1;
        emps[2] = emp2;
        //    for (int i = 0; i < emp0.length; i++) {
        //      System.out.println(Arrays.toString(emps[i]));
        //}
        for (int i = 0; i < emps.length; i++) {
            for (int j = 0; j < emps[i].length; j++) {
                System.out.print(emps[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
