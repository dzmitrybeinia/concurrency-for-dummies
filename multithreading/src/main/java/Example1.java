public class Example1 {
    public static void main(String[] args) {
        MyThreadEx1 myThread1 = new MyThreadEx1();
        MyThreadEx1 myThread2 = new MyThreadEx1();
        myThread1.start();
        myThread2.start();
    }
}

class MyThreadEx1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}