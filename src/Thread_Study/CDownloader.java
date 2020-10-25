package Thread_Study;

import java.util.concurrent.*;

public class CDownloader implements Callable<Boolean> {
    private String url;
    private String name;

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1 = new CDownloader("https://hao.360.com/?src=lm&ls=n3db425c399", "360.html");
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        //提交执行
        Future<Boolean> rwsult1 = ser.submit(cd1);
        //获取结果
        boolean r1 = rwsult1.get();
        //关闭服务
        ser.shutdownNow();
    }
}
