public class Example7 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begins");
        Thread worker1 = new Thread(new Worker());
        worker1.start();
        worker1.join();

        Thread worker2 = new Thread(new Worker());
        worker2.start();
        worker2.join(300);
        System.out.println("main ends");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends");
    }
}
