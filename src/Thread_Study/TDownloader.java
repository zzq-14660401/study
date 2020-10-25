package Thread_Study;

public class TDownloader extends Thread {
    private String url;
    private String name;

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url, name);
    }

    public static void main(String[] args) {
        TDownloader td1 = new TDownloader("https://hao.360.com/?src=lm&ls=n3db425c399","360.html");
       // TDownloader td2 = new TDownloader("","");
       // TDownloader td3 = new TDownloader("","");
        td1.start();
        //td2.start();
       // td3.start();
    }
}
