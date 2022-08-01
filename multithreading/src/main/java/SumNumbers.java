import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = Instant.now().toEpochMilli();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();
        long div = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = div * i + 1;
            long to = div * (i + 1);
            PartialSum partialSum = new PartialSum(from, to);
            Future<Long> future = executorService.submit(partialSum);
            futures.add(future);
        }
        for (Future<Long> result: futures) {
            sum += result.get();
        }

        long end = Instant.now().toEpochMilli();
        System.out.println(end - start);
        System.out.println(sum);


        executorService.shutdown();


    }
}

class PartialSum implements Callable<Long> {

    private long from;
    private long to;
    private long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}