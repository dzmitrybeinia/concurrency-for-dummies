public class Example7 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main begins");
        Thread worker = new Thread(new Worker());
        worker.start();
        worker.join();
        System.out.println("main ends");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("worker starts");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("worker ends");
    }
}
