public class Example4 implements Runnable {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Example4());
        System.out.println("thread name = " + myThread.getName());
        System.out.println("thead priority = " + myThread.getPriority());

        myThread.setName("thread - 10");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("thread name = " + myThread.getName());
        System.out.println("thead priority = " + myThread.getPriority());
    }

    @Override
    public void run() {

    }
}
