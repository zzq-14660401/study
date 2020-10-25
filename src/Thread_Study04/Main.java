package Thread_Study04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static int count=0;
    public static int count2=0;
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(200);
        for (int i = 0; i < 2000; i++) {
            threadPool.submit(Main::incIt);
        }
        threadPool.shutdown();
        while (!threadPool.isTerminated()){
        }
        System.out.println(count);

    }

    private synchronized static void incIt() {
        count++;
        count2++;
    }
}
