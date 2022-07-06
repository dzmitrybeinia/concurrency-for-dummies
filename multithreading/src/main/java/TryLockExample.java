import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("aaa", lock);
        new Employee("bbb", lock);
        new Employee("ccc", lock);
        Thread.sleep(7000);
        new Employee("ddd", lock);
        new Employee("eee", lock);

    }
}

class Employee extends Thread {
    private final String name;
    private final Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        if(lock.tryLock()) {
            try {
                System.out.println(name + " use the terminal");
                Thread.sleep(3000);
                System.out.println(name + " stop use the terminal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " leaves");
        }
    }
}
