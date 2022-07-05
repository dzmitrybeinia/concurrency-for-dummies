public class SynchronizedBlock {
    public static void main(String[] args) {
        MyRunnableSyncBlock myRunnableSyncBlock = new MyRunnableSyncBlock();
        Thread thread1 = new Thread(myRunnableSyncBlock);
        Thread thread2 = new Thread(myRunnableSyncBlock);
        Thread thread3 = new Thread(myRunnableSyncBlock);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class CountBlock {
    volatile static int count = 0;
}

class MyRunnableSyncBlock implements Runnable {

    private void doSomething() {
        System.out.println("do something");
    }

    private void increment() {
        doSomething();
        synchronized (this) {
            CountBlock.count++;
            System.out.println("counter = " + CountBlock.count);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            increment();
        }
    }
}
