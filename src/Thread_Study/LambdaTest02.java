package Thread_Study;

public class LambdaTest02 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("一边学习");
        }).start();
        new Thread(() ->
                System.out.println("一边崩溃")).start();
    }
}
