public class DeadLock {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        ThreadDeadLock1 threadDeadLock1 = new ThreadDeadLock1();
        ThreadDeadLock2 threadDeadLock2 = new ThreadDeadLock2();

        threadDeadLock1.start();
        threadDeadLock2.start();
    }
}

class ThreadDeadLock1 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadDeadLock1: try to get a monitor of lock1");
        synchronized (DeadLock.lock1) {
            System.out.println("ThreadDeadLock1: lock1 - success");
            System.out.println("ThreadDeadLock1: try to get a monitor of lock2");
            synchronized (DeadLock.lock2) {
                System.out.println("ThreadDeadLock1: lock1, lock2 - success");
            }
        }
    }
}

class ThreadDeadLock2 extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadDeadLock2: try to get a monitor of lock2");
        synchronized (DeadLock.lock2) {
            System.out.println("ThreadDeadLock2: lock2 - success");
            System.out.println("ThreadDeadLock2: try to get a monitor of lock1");
            synchronized (DeadLock.lock1) {
                System.out.println("ThreadDeadLock2: lock1, lock2 - success");
            }
        }
    }
}