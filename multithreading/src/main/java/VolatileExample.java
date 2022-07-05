public class VolatileExample extends Thread {
    volatile boolean b = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();
        Thread.sleep(1);
        thread.b = false;
        thread.join();
    }

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("counter = " + counter);
    }
}
