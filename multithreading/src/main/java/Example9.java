public class Example9 {
    public static void main(String[] args) {
        MyRunnableEx9 myRunnableEx9 = new MyRunnableEx9();
        Thread thread1 = new Thread(myRunnableEx9);
        Thread thread2 = new Thread(myRunnableEx9);
        Thread thread3 = new Thread(myRunnableEx9);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    public static int count = 0;
}

class MyRunnableEx9 implements Runnable {

    public void increment() {
        Counter.count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
            System.out.println("counter = " + Counter.count);
        }
    }
}