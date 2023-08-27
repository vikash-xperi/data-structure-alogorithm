package revision.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianOfRunningStream {
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insert(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        FindMedianOfRunningStream obj = new FindMedianOfRunningStream();
        obj.insert(5);
        obj.insert(1);
        obj.insert(3);
        System.out.println(obj.findMedian());

    }
}
