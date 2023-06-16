package corejava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    private static ExecutorService executorService;
    public static void main(String args[]) throws InterruptedException {
        executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; ++i) {
            executorService.execute(new MyThread("Vikash"));
            Thread.sleep(200);
        }
    }
}
class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
