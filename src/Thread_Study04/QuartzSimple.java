package Thread_Study04;

/**
 * [说明/描述]
 * @author Edon-Du
 * @date 2018-6-25
 * @copyright copyright (c) 2018
 */

public class QuartzSimple {
    public static void main(String[] args) {
        //简单任务调度，每隔多少时间执行一次，执行n次
        SchedulerUtil.handleSimpleTrigger("44033", "3333", "44033", "3333", MyJob.class, 1, 8);
        //复杂调度，每天的什么时候执行任务
        SchedulerUtil.hadleCronTrigger("44033", "3333", "44033", "3333", MyJob.class, "0 19 19 * * ? *");
    }
}