public class Example8 {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Starter());
        System.out.println(myThread.getState());

        myThread.start();
        System.out.println(myThread.getState());

        myThread.join();
        System.out.println(myThread.getState());
    }
}

class Starter implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends");
    }
}