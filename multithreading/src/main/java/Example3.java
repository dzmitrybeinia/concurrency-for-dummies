public class Example3 implements Runnable {
    public static void main(String[] args) {
        Thread myThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        });
        myThread1.start();

        Thread myThread2 = new Thread(new Example3());
        myThread2.start();

        Thread myThread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        myThread3.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
