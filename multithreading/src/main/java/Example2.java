public class Example2 {
    public static void main(String[] args) {
        Thread myThread1 = new Thread(new MyThreadEx2());
        Thread myThread2 = new Thread(new MyThreadEx2());

        myThread1.start();
        myThread2.start();
    }
}

class MyThreadEx2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}