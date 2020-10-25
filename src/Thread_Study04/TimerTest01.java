package Thread_Study04;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class TimerTest01 {
    public static void main(String[] args) {
//        Timer timer = new Timer();
//        //执行安排
//        //  timer.schedule(new MyTask(), 5000); //5s后执行一次
//        //  timer.schedule(new MyTask(), 5000, 1000); //5s后开始执行,每间隔1s执行一次
//        Calendar calendar = new GregorianCalendar(2020,10,25,15,03,0);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.getTime());
//        timer.schedule(new MyTask(), calendar.getTime(), 1000);
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1400);
//        scheduledThreadPool.scheduleAtFixedRate(new MyTask(), 0, 2, TimeUnit.SECONDS);
//        scheduledThreadPool.scheduleWithFixedDelay(new MyTask(), 0, 2, TimeUnit.SECONDS);

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10000; i++) {
            threadPool.submit(new MyTask());
//            new Thread(new MyTask()).start();
        }
        threadPool.shutdown();
        System.out.println("main end");

    }
}

//任务类
class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "hello wrold:" + new Date());
    }
}
