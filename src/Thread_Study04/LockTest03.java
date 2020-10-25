package Thread_Study04;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁:锁可以延续使用+计数器
 */
public class LockTest03 {
    ReentrantLock lock = new ReentrantLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest03 lockTest = new LockTest03();
        lockTest.a();
        Thread.sleep(1000);
        System.out.println(lockTest.lock.getHoldCount());

    }
}

