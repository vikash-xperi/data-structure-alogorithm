package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxAndMinElement {
    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000 };
        int k = 3;
        Pair kthMaxAndMin = solve(arr, k);
        System.out.println("Minimum: "+ kthMaxAndMin.min);
        System.out.println("Maximum: "+ kthMaxAndMin.max);
    }

    private static Pair solve(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        Arrays.stream(arr).forEach(x -> {
            minHeap.add(x);
            maxHeap.add(x);
        });
        while (--k != 0) {
            minHeap.poll();
            maxHeap.poll();
        }
        return new Pair(minHeap.peek(), maxHeap.peek());
    }
}
