public class WaitNotify {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Market {
    private final Object lock = new Object();
    private int breadCount = 0;

    public void getBread() {
        synchronized (lock) {
            while (breadCount < 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;
            System.out.println("Consumer get 1 bread");
            System.out.println("Amount of bread = " + breadCount);
            lock.notify();
        }
    }

    public void putBread() {
        synchronized (lock) {
            while (breadCount >= 5) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount++;
            System.out.println("Producer add 1 bread");
            System.out.println("Amount of bread = " + breadCount);
            lock.notify();
        }
    }
}

class Producer implements Runnable {
    private final Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    private final Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            market.getBread();
        }
    }
}