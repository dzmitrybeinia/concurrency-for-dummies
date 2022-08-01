import java.util.concurrent.*;

public class CallableFactorial {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(7);
        Future<Integer> future = executorService.submit(factorial);
        executorService.shutdown();
        System.out.println(future.isDone());
        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}

class Factorial implements Callable<Integer> {

    private final int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws IllegalArgumentException, InterruptedException {
        if(f <= 0) {
            throw new IllegalArgumentException("f <= 0");
        }
        int res = 1;
        for (int i = 1; i <= f; i++) {
            Thread.sleep(1000);
            res *= i;
        }
        return res;
    }
}