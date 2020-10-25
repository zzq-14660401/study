package Thread_Study04;

/**
 * 不可重入锁:锁不可以延续使用
 */
public class LockTest02 {
    Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    public void doSomething() throws InterruptedException {
        lock.lock();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 lockTest = new LockTest02();
        lockTest.a();
        lockTest.doSomething();

    }
}

class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
