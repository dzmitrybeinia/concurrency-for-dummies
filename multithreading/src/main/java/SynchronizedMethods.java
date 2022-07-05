public class SynchronizedMethods {
    private static final Lock lock = new Lock();
    void mobileCall() {
        synchronized (lock) {
            System.out.println("mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("skype call ends");
        }
    }

    void telegramCall() {
        synchronized (lock) {
            System.out.println("telegram call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("telegram call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MobileRunnable());
        Thread thread2 = new Thread(new SkypeRunnable());
        Thread thread3 = new Thread(new TelegramRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MobileRunnable implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethods().mobileCall();
    }
}

class SkypeRunnable implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethods().skypeCall();
    }
}

class TelegramRunnable implements Runnable {
    @Override
    public void run() {
        new SynchronizedMethods().telegramCall();
    }
}

class Lock {}