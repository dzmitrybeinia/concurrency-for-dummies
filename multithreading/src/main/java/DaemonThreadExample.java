public class DaemonThreadExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);

        myThread.start();
        daemonThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for(char i = 'A'; i <= 'Z'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for(int i = 1; i <= 100; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}