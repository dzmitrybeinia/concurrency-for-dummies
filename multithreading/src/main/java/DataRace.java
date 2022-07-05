public class DataRace {
    public static int counter = 0;
    public static void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDataRace runnableDataRace = new RunnableDataRace();
        Thread thread1 = new Thread(runnableDataRace);
        Thread thread2 = new Thread(runnableDataRace);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("counter = " + counter);
    }
}

class RunnableDataRace implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            DataRace.increment();
        }
    }
}