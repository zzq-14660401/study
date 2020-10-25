package Thread_Study04;

import java.util.concurrent.*;

public class Test08 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Future<Boolean> submit1 = executorService.submit(new Emial());
        Future<Boolean> submit2 = executorService.submit(new Message());
        Result result = new Result();

        if (submit1.get()) {
            result.setEmail(true);
        } else {
            result.setEmail(false);
        }

        if (submit2.get()) {
            result.setMassage(true);
        } else {
            result.setMassage(false);
        }

        System.out.println(result);
        executorService.shutdown();

    }
}

class Emial implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        int a = (int) (Math.random() * 100);
        Thread.sleep(2000);
        if (a < 50) {
            System.out.println("邮件发送失败了!-->" + a);
            return false;
        } else {
            System.out.println("邮件发送成功!-->" + a);
            return true;
        }
    }
}

class Message implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        int a = (int) (Math.random() * 100);
        Thread.sleep(1000);
        if (a < 50) {
            System.out.println("短信发送失败了!-->" + a);
            return false;
        } else {
            System.out.println("短信发送成功!-->" + a);
            return true;
        }
    }
}

class Result {
    private Boolean email;
    private Boolean massage;


    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

    public Boolean getMassage() {
        return massage;
    }

    public void setMassage(Boolean massage) {
        this.massage = massage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "email=" + email +
                ", massage=" + massage +
                '}';
    }
}

