public class Synchronized {
    public static void main(String[] args) {
        MyRunnableSync myRunnableSync = new MyRunnableSync();
        Thread thread1 = new Thread(myRunnableSync);
        Thread thread2 = new Thread(myRunnableSync);
        Thread thread3 = new Thread(myRunnableSync);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Count {
    volatile static int count = 0;
}

class MyRunnableSync implements Runnable {

    public synchronized void increment() {
        Count.count++;
        System.out.println("counter = " + Count.count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
