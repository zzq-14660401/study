package Thread_Study;

/**
 * 接口:
 * 1.真实角色
 * 2.代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).HappyMarry();
    }

}

interface Marry {
    void HappyMarry();
}

class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("you");
    }
}

class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        ready();
        this.target.HappyMarry();
        after();
    }

    private void ready() {
        System.out.println("布置");
    }

    private void after() {
        System.out.println("收拾");
    }
}
