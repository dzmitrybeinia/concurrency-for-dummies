public class Example5 implements Runnable {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Example5());
        myThread.start();
        myThread.run();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName());
    }
}
