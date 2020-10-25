package Thread_Study04;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * [任务类]
 * @author Edon-Du
 * @date 2018-6-25 
 * @copyright copyright (c) 2018
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Hello World");

    }
}