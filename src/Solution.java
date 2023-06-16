import java.util.Random;
import java.util.concurrent.*;

public class Solution {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(new Task());
        try {
            System.out.println("Result from the task is " + future.isDone());
            Thread.sleep(100);
//            Integer result = future.get();
            System.out.println("Result from the task is " + future.isDone());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
